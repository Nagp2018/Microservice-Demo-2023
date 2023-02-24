package com.nagarro.nagp.model;



public class Product {

	private String id;
	private String productCode;
	private String productName;
	private int productQty;
	private String productPrice;
	
	
    public Product(){
		
	}
	
	public Product(String id,String productCode, String productName,int productQty,String productPrice){
		super();
		
		this.id = id;
		this.productCode = productCode;
		this.productName = productName;
		this.productQty = productQty;
		this.productPrice = productPrice;
		
		
	}
	
	
	/**
	 * @return the productPrice
	 */
	public String getProductPrice() {
		return productPrice;
	}
	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}
	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	/**
	 * @return the productQty
	 */
	public int getProductQty() {
		return productQty;
	}
	/**
	 * @param productQty the productQty to set
	 */
	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	
	
}
