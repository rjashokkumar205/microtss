package com.ecommerce.OrderService.entity;

public class Card {

	private Integer cardNumber;

	private Integer cardCVV;

	private String cardOwner;

	

	

	public Integer getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Integer getCardCVV() {
		return cardCVV;
	}

	public void setCardCVV(Integer cardCVV) {
		this.cardCVV = cardCVV;
	}

	public String getCardOwner() {
		return cardOwner;
	}

	public void setCardOwner(String cardOwner) {
		this.cardOwner = cardOwner;
	}

	public Card(Integer cardNumber, Integer cardCVV, String cardOwner) {

		super();

		this.cardNumber = cardNumber;

		this.cardCVV = cardCVV;

		this.cardOwner = cardOwner;

	}

	public Card() {

		super();

		// TODO Auto-generated constructor stub

	}

}
