package com.ecommerce.OrderService.entity;


public class OrderDto{
	
	private String orderId;
	private Integer cartId;
	private Integer userId;
	private Address shippingAddress;
	private Payment paymentMethods;
	private Card cardDetails;
	
	public OrderDto() {
	
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public Payment getPaymentMethods() {
		return paymentMethods;
	}
	public void setPaymentMethods(Payment paymentMethods) {
		this.paymentMethods = paymentMethods;
	}
	public Card getCardDetails() {
		return cardDetails;
	}
	public void setCardDetails(Card cardDetails) {
		this.cardDetails = cardDetails;
	}

	public OrderDto(String orderId, Integer cartId, Integer userId, Address shippingAddress, Payment paymentMethods,
			Card cardDetails) {
		this.orderId = orderId;
		this.cartId = cartId;
		this.userId = userId;
		this.shippingAddress = shippingAddress;
		this.paymentMethods = paymentMethods;
		this.cardDetails = cardDetails;
	}
	
	
	
	
	
}