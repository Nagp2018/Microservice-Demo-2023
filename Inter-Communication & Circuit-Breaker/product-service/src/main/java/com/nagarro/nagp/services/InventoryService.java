package com.nagarro.nagp.services;

import java.util.Collection;

import com.nagarro.nagp.model.Order;
import com.nagarro.nagp.model.Product;





public interface InventoryService {

	public Collection<Product> getAllProducts();
	
	public Product getProduct(String id);
	
	public String addProduct(Product product);
	
	public String updateProduct(String id,Product product);
	
	public void isAvailable(String order);
}
