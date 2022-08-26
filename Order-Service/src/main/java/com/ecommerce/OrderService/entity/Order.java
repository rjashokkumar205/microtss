package com.ecommerce.OrderService.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Order {

	@Id
	private String orderId;

	private Cart cartDetails;

	private User userDetails;

	private Address shippingAddress;

	private Payment paymentMethods;

	private Card cardDetails;

	private Date orderDate = new Date();

	public String getOrderId() {

		return orderId;

	}

	public void setOrderId(String orderId) {

		this.orderId = orderId;

	}

	public Cart getCartDetails() {

		return cartDetails;

	}

	public void setCartDetails(Cart cartDetails) {

		this.cartDetails = cartDetails;

	}

	public void setUserDetails(User userDetails) {

		this.userDetails = userDetails;

	}

	public User getUserDetails() {
		return userDetails;
	}

	public void setShippingAddress(Address shippingAddress) {

		this.shippingAddress = shippingAddress;

	}

	public Address getShippingAddress() {
		return shippingAddress;
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

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public void setCardDetails(Card cardDetails) {

		this.cardDetails = cardDetails;

	}

	public Order() {

	}

	public Date getOrderDate() {
		return orderDate;
	}

}
