package com.example.nagp.orderdemo.model;


public class OrderFailedEventProductMessage {

	private String orderId;

	public OrderFailedEventProductMessage() {
		super();
	}

	public OrderFailedEventProductMessage(String orderId) {
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
		return "OrderFailedEventMessage [orderId=" + orderId + "]";
	}

}
