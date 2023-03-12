package com.example.nagp.orderdemo.service;





import org.springframework.validation.annotation.Validated;

import com.example.nagp.orderdemo.model.Order;

import java.util.List;

@Validated
public interface OrderService {



    Order addOrder(Order order);

    
	Order getOrder(String orderId);
	
	public void confirmOrder(String id);
	
	public void UnConfirmOrder(String id);

	
}