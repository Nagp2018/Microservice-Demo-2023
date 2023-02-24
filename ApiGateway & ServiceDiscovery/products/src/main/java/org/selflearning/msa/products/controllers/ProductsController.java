package org.selflearning.msa.products.controllers;

import javax.annotation.Resource;

import org.selflearning.msa.products.entities.Product;
import org.selflearning.msa.products.services.ProductsDetailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductsController {

	private final ProductsDetailService productsDetailService;

	public ProductsController(ProductsDetailService productsDetailService) {
		this.productsDetailService = productsDetailService;
	}

	@GetMapping(value = "/{designNumber}")
	Product getProductDetails(@PathVariable(name = "designNumber") String designNumber) {
		return productsDetailService.getProductByDesignNumber(designNumber);
	}
}
