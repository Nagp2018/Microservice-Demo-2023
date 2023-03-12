package com.example.nagp.orderdemo.resource;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.nagp.orderdemo.Configuration;
import com.example.nagp.orderdemo.model.Order;
import com.example.nagp.orderdemo.service.OrderService;





@RestController
@RequestMapping("/api/order")
public class OrderController {

	
	@Autowired
	Configuration configuration;
	
	@Autowired
	OrderService orderService;

	
	@GetMapping("/{orderId}")
	public Order getOrder(@PathVariable String orderId) {
		return orderService.getOrder(orderId);
	}
	
	
	@PostMapping
	public Order createOrder(@RequestBody Order order) {
		
		Optional.ofNullable(order.getAddress()).orElse("Address can not be empty");
		
		return  orderService.addOrder(order);
		
	}	
	
	

}