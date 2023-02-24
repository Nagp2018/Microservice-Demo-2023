package com.nagarro.nagp.dao;

import java.util.Collection;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.springframework.stereotype.Component;

import com.nagarro.nagp.model.Product;




@Component
public class InventoryDaoImpl{

	
	private final ConcurrentMap<String, Product> products  = new ConcurrentHashMap<>();
	
	
	public Collection<Product> getAllProducts() {
		
			return products.values();
	
	}


	public Product getProduct(final String id) {
		return products.get(id);
	}

	
	public void insertProduct(final Product product) {
		if(Objects.isNull(product.getId())){
			product.setId(UUID.randomUUID().toString());
		}		
		
		 products.put(product.getId(), product);
	}

	
	public String updateProduct(String id, Product product) {
		if (products.containsKey(id)) {
			 products.put(id, product);
		} 
		return "Product Detail Updated";
	}


	public boolean isAvailable(String id) {
		if (products.containsKey(id)) {
			 return products.get(id).getProductQty() > 0 ? true : false;
		} 
		return false;
	}

	
	

}
