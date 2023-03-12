package com.example.nagp.orderdemo.model;


public class OrderCreatedEventMessage {

	private String orderId;

	public OrderCreatedEventMessage() {
		super();
	}

	public OrderCreatedEventMessage(String orderId) {
		super();
		this.orderId = orderId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "OrderCreatedEventMessage [orderId=" + orderId + "]";
	}

}
