package com.ecommerce.CartService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.CartService.entity.Cart;
import com.ecommerce.CartService.entity.CartItemDto;
import com.ecommerce.CartService.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	CartService cartService;

	@PostMapping("/{cartId}")
	public String addToCart(@PathVariable("cartId") Integer cartId, @RequestBody CartItemDto item) {

		cartService.addItem(cartId, item);

		return "added";

	}

	@DeleteMapping("/{cartId}/cartItem/{cartItemId}")
	public String deleteCartItem(@PathVariable("cartId") Integer cartId, @PathVariable("cartItemId") Integer itemId) {

		cartService.deleteItem(cartId, itemId);
		return "deleted";
	}

	@PutMapping("/{cartId}/cartItem/{cartItemId}")
	public String updateQuantity(@PathVariable("cartId") Integer cartId, @PathVariable("cartItemId") Integer itemId,

			@RequestParam("quantity") Integer quantity) {

		return cartService.updateQuantity(cartId, itemId, quantity);

	}
	
	@GetMapping("/{cartId}")
	public Cart getCart(@PathVariable Integer cartId) {
		return cartService.getSingleCart(cartId);
	}
}
