package org.selflearning.msa.products.services.impl;

import com.netflix.discovery.EurekaClient;
import org.selflearning.msa.products.entities.Product;
import org.selflearning.msa.products.services.ProductsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultProductsDetailService implements ProductsDetailService {

	@Value("${server.port}")
	private int port;

	@Autowired
	private EurekaClient eurekaClient;

	@Autowired
	private RestTemplate restTemplate;

	public Product getProductByDesignNumber(String designNumber) {
		Optional<Product> result = getAllProducts().stream()
				.filter(p -> designNumber.equals(p.getDesignNumber())).findFirst();
		if (result.isPresent()) {
			String baseUrl = eurekaClient.getNextServerFromEureka("prices", false).getHomePageUrl() + "prices";
			System.out.println("making call to :- "+baseUrl);
			ResponseEntity<Double> response = null;
			Product product = result.get();
			try {
				UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseUrl)
						.queryParam("goldWeight", product.getGoldWeight())
						.queryParam("goldPurity", product.getGoldPurity())
						.queryParam("pearlsWeight", product.getPearlsWeight());
				response = restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.GET, null,
						Double.class);
			} catch (Exception ex) {
				System.out.println(ex);
			}

			product.setPrice(response.getBody());
			product.setDescription(product.getDescription()+ " from product service port " + port +" price endpoint "+ baseUrl );
			return product;
		}
		return null;
	}


	protected List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		products.add(new Product("001", "Men Ring", 7.08D, "22", 0.0D));
		products.add(new Product("002", "Women Ring", 6.50D, "22", 0.0D));
		products.add(new Product("003", "Men Chain", 17.06D, "22", 0.0D));
		products.add(new Product("004", "Women Chain", 15.33D, "22", 0.0D));
		products.add(new Product("005", "Women Bangle", 22.76D, "22", 0.0D));
		products.add(new Product("006", "Women Earings", 10.54D, "22", 4.35D));
		products.add(new Product("007", "Women Necklace", 33.52D, "22", 12.40D));
		return products;
	}
}
