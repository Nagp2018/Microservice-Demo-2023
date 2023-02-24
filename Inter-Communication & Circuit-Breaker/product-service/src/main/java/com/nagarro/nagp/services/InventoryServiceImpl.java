package com.nagarro.nagp.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.JsonSerializerUtil;
import com.nagarro.nagp.dao.InventoryDaoImpl;
import com.nagarro.nagp.model.Order;
import com.nagarro.nagp.model.Product;




@Service
public class InventoryServiceImpl implements InventoryService{

	
	private final InventoryDaoImpl inventoryDao;
	
	@Autowired 
	private JmsTemplate jmsTemplate;
	 
	@Autowired(required=false)
	public InventoryServiceImpl(final InventoryDaoImpl inventoryDao) {
	        this.inventoryDao = inventoryDao;
	}
	    
	@Override
	public Collection<Product> getAllProducts() {
		Collection<Product> allProducts = inventoryDao.getAllProducts();
		
		return allProducts.isEmpty() ? Collections.emptyList() : new ArrayList<>(allProducts);
	}

	@Override
	public Product getProduct(final String id) {
		return inventoryDao.getProduct(id);
	}

	@Override
	public String addProduct(final Product product) {
		inventoryDao.insertProduct(product);
		return "Product Added to Inventory";
	}

	@Override
	public String updateProduct(final String id,final Product product) {
		inventoryDao.updateProduct(id, product);
		return "Product Details Updated";
	}

	@Override
	@JmsListener(destination="OrderRequestReceivedEvent")
	public void isAvailable(String orderPayload) {
		Order order = JsonSerializerUtil.orderPayload(orderPayload);
		
		System.out.println("messgae received in inventory");
		 if(inventoryDao.isAvailable(order.getProductId())){
			  sendInventoryAvaliableEvent(order.getOrderID());
		 }else{
			 sendProductNotAvailable(order.getOrderID());
		 }
	}
	
	public void sendInventoryAvaliableEvent(String productID){
		System.out.println("InventoryAvaliableEvent");
		jmsTemplate.convertAndSend("InventoryAvaliableEvent", productID);
	}
	
	public void sendProductNotAvailable(String productID){
		System.out.println("InventoryNotAvaliableEvent");
		jmsTemplate.convertAndSend("InventoryNotAvaliableEvent", productID);
	}

	

	
}
