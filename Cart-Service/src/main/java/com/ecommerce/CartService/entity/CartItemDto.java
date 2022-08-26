package com.ecommerce.CartService.entity;

public class CartItemDto {
	private Integer cartItemId;

	private Integer productId;

	private Integer quantity;

	public CartItemDto(Integer cartItemId, Integer productId, Integer quantity) {
		
		this.cartItemId = cartItemId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public CartItemDto() {
		
	}

	public Integer getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(Integer cartItemId) {
		this.cartItemId = cartItemId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	

}
