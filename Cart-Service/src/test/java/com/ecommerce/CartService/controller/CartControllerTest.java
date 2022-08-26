package com.ecommerce.CartService.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.CartService.entity.Cart;
import com.ecommerce.CartService.entity.CartItem;
import com.ecommerce.CartService.entity.CartItemDto;
import com.ecommerce.CartService.entity.Category;
import com.ecommerce.CartService.entity.Product;
import com.ecommerce.CartService.service.CartService;

@SpringBootTest(classes = { CartControllerTest.class })
public class CartControllerTest {

	@Mock
	CartService cartService;

	@InjectMocks
	CartController cartController;

	@Test
	public void test_addToCart() {
		Integer cartId = 6;

		CartItemDto dto = new CartItemDto();
		dto.setCartItemId(1);
		dto.setProductId(102);
		dto.setQuantity(3);
		;

		when(cartService.addItem(cartId, dto)).thenReturn("added");

		String res = cartController.addToCart(cartId, dto);
		assertEquals("added", res);
	}

	@Test
	public void test_deleteCartItem() {
		when(cartService.deleteItem(60, 70)).thenReturn("deleted");
		String res = cartController.deleteCartItem(60, 70);
		assertEquals("deleted", res);

	}

	@Test
	public void test_updateQuantity() {

		when(cartService.updateQuantity(6, 7, 8)).thenReturn("updated");
		String res = cartController.updateQuantity(6, 7, 8);
		assertEquals("updated", res);
	}

	@Test
	public void test_getCart() {

		Category category1 = new Category(7, "gfs");

		Category category2 = new Category();
		category2.setCategoryId(category2.getCategoryId());
		category2.setCategoryName(category2.getCategoryName());

		Product product1 = new Product();
		product1.setCategory(category1);
		product1.setDescription("scac");
		product1.setDiscountedPrice(700);
		product1.setProductId(10);
		product1.setProductName("dxdw");
		product1.setProductRating(4);
		product1.setProductReview("qdd");
		product1.setQuantity(40);
		product1.setRegularPrice(500);

		Product product2 = new Product(8, "hp", "hhjjhj", 20, 900, 800, 2, "hghjhj", category2);

		CartItem item1 = new CartItem();
		item1.setCartItemId(12);
		item1.setQuantity(5);
		item1.setPrice(700);
		item1.setProduct(product1);

		CartItem item2 = new CartItem();
		item2.setCartItemId(7);
		item2.setQuantity(6);
		item2.setPrice(600);
		item2.setProduct(product2);

		List<CartItem> items = new ArrayList<CartItem>();

		items.add(item1);
		items.add(item2);

		Cart cart = new Cart();

		cart.setCartId(5);
		cart.setCartItems(items);
		cart.setGrandTotal(300d);

		when(cartService.getSingleCart(5)).thenReturn(cart);

		Cart cartSample = cartController.getCart(5);

		assertEquals(cartSample, cart);

	}

}
