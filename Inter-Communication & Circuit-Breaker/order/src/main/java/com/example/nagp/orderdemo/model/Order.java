package com.example.nagp.orderdemo.model;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Order implements Serializable{
	

	private String userID;
	private String orderID;
	private String address;
	private String totalQty;
	private String amount;
	private String remarks;
	private String productId;
	private OrderStatus orderStatus;
	
	

   public Order(){
		
	}
	
	public Order(String userID,String orderID,String address, String totalQty,OrderStatus orderStatus,String productId){
		super();
		this.userID = userID;
		this.orderID = orderID;
		this.address = address;
		this.totalQty = totalQty;
		this.orderStatus = orderStatus;
		this.productId = productId;
		
	}

	



	public OrderStatus getOrderStatus() {
		return this.orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getTotalQty() {
		return this.totalQty;
	}
	public void setTotalQty(String totalQty) {
		this.totalQty = totalQty;
	}
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOrderID() {
		return this.orderID;
	}
	public void setorderID(String orderID) {
		this.orderID = orderID;
	}

	

	/**
	 * @return the product
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @param product the product to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	

	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
}
