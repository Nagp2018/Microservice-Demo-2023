package com.example.nagp.orderdemo.service;

import java.time.Instant;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.example.nagp.orderdemo.JsonSerializerUtil;
import com.example.nagp.orderdemo.kafka.producer.OrderPlacedEventProcessor;
import com.example.nagp.orderdemo.model.Order;
import com.example.nagp.orderdemo.model.OrderCreatedEventMessage;
import com.example.nagp.orderdemo.model.OrderStatus;
import com.example.nagp.orderdemo.rabbitmq.producer.OrderCreatedEventProducer;
import com.example.nagp.orderdemo.rabbitmq.producer.OrderFailedEventProducer;


@Service
public class OrderServiceImpl implements OrderService {

	private  Map<String, Order> orders  = new ConcurrentHashMap<String, Order>();
	
	@Autowired 
	private JmsTemplate jmsTemplate;
	
	/*@Autowired
	private OrderFailedEventProducer orderFailedEventProducer;

	@Autowired
	private OrderCreatedEventProducer orderCreatedEventProducer;
	
	@Autowired
	private OrderPlacedEventProcessor orderPlacedEventProducer;*/
	
	@Override
	public Order addOrder(Order order) {
		
		
		if(Objects.isNull(order.getOrderID())){
			order.setorderID(UUID.randomUUID().toString());
		}
		
		order.setOrderStatus(OrderStatus.PROCESSING);	
	
		
		String ProductID = order.getProductId();
		
		this.orders.put(order.getOrderID(), order);	
		
		System.out.print("product ID "+ ProductID + "  Order "+ this.orders);
		
		//ActiveMQ
		jmsTemplate.convertAndSend("OrderRequestReceivedEvent",JsonSerializerUtil.serialize(order));
		
		
		return order;
	}

	@Override
	public Order getOrder(String orderId) {
		System.out.print("Order"+ this.orders.get(orderId));
		return this.orders.get(orderId);
	}
	
	
	/**
	 * Consume Event from Inventory using ActiveMQ
	 */
	@Override
	@JmsListener(destination="InventoryAvaliableEvent")
	public void confirmOrder(String id) {
		System.out.println("InventoryAvaliableEvent for Product" + id);
		
		Order order = this.orders.get(id);
		order.setOrderStatus(OrderStatus.CONFIRMED);
		this.orders.put(order.getOrderID(), order);		
		
		//jmsTemplate.convertAndSend("CreateOrderShippingEvent", order.getOrderID());
		//RabbbitMQ
		/*this.orderCreatedEventProducer
		.produceEventOrderCreatedDelivery(new OrderCreatedEventMessage(order.getOrderID()));*/
		
	}
	
	/**
	 * Consume Event from Inventory using ActiveMQ
	 */
	@Override
	@JmsListener(destination="InventoryNotAvaliableEvent")
	public void UnConfirmOrder(String id) {
		System.out.println("InventoryNotAvaliableEvent");
		Order order = this.orders.get(id);
		order.setOrderStatus(OrderStatus.UNCONFIRMED);
		order.setRemarks("Product is out of stock");
		this.orders.put(order.getOrderID(), order);
		

		//Kafka
		/* orderPlacedEventProducer.sendMessage("InitiateRefund" +
				 order.getOrderID() + order.getAmount().toString());*/
		
		
	}


}
