package com.ecommerce.ProductService.VO;

import com.ecommerce.ProductService.entity.Product;

public class ResponseTemplateVO {
	
	private Integer productId;

	private String productName;

	private String description;

	private Integer quantity;

	private Integer regularPrice;

	private Integer discountedPrice;

	private Integer productRating;

	private String productReview;

	public Category category;
	
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getRegularPrice() {
		return regularPrice;
	}
	public void setRegularPrice(Integer regularPrice) {
		this.regularPrice = regularPrice;
	}
	public Integer getDiscountedPrice() {
		return discountedPrice;
	}
	public void setDiscountedPrice(Integer discountedPrice) {
		this.discountedPrice = discountedPrice;
	}
	public Integer getProductRating() {
		return productRating;
	}
	public void setProductRating(Integer productRating) {
		this.productRating = productRating;
	}
	public String getProductReview() {
		return productReview;
	}
	public void setProductReview(String productReview) {
		this.productReview = productReview;
	}
	public ResponseTemplateVO(Integer productId, String productName, String description, Integer quantity,
			Integer regularPrice, Integer discountedPrice, Integer productRating, String productReview,
			Category category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.quantity = quantity;
		this.regularPrice = regularPrice;
		this.discountedPrice = discountedPrice;
		this.productRating = productRating;
		this.productReview = productReview;
		this.category = category;
	}
	public ResponseTemplateVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	

}
