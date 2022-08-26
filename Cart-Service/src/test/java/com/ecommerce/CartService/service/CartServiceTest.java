package com.ecommerce.CartService.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.CartService.controller.CartControllerTest;
import com.ecommerce.CartService.entity.Cart;
import com.ecommerce.CartService.entity.CartItem;
import com.ecommerce.CartService.entity.CartItemDto;
import com.ecommerce.CartService.entity.Category;
import com.ecommerce.CartService.entity.Product;
import com.ecommerce.CartService.repository.CartRepository;

@SpringBootTest(classes = { CartServiceTest.class })
public class CartServiceTest {

	@Mock
	CartRepository cartRepo;

	@Mock
	RestTemplate restTemplate;

	@InjectMocks
	CartService cartService;

	/*
	 * @Test public void test_addItem() {
	 * 
	 * CartItemDto dto = new CartItemDto();
	 * 
	 * dto.setCartItemId(dto.getCartItemId()); dto.setProductId(dto.getProductId());
	 * dto.setQuantity(dto.getQuantity());
	 * 
	 * CartItemDto dto2 = new CartItemDto(5,7,90);
	 * 
	 * Category category1 = new Category(7,"gfs");
	 * 
	 * Category category2 = new Category();
	 * category2.setCategoryId(category2.getCategoryId());
	 * category2.setCategoryName(category2.getCategoryName());
	 * 
	 * Product product1 = new Product();
	 * product1.setCategory(product1.getCategory());
	 * product1.setDescription(product1.getDescription());
	 * product1.setDiscountedPrice(product1.getDiscountedPrice());
	 * product1.setProductId(product1.getProductId());
	 * product1.setProductName(product1.getProductName());
	 * product1.setProductRating(product1.getProductRating());
	 * product1.setProductReview(product1.getProductReview());
	 * product1.setQuantity(product1.getQuantity());
	 * product1.setRegularPrice(product1.getRegularPrice());
	 * 
	 * Product product2 = new
	 * Product(8,"hp","hhjjhj",20,900,800,2,"hghjhj",category2);
	 * 
	 * when(restTemplate.getForObject("http://localhost:9093/products/" +
	 * dto.getProductId(), Product.class)).thenReturn(product1);
	 * 
	 * CartItem item1 = new CartItem(); item1.setCartItemId(item1.getCartItemId());
	 * item1.setPrice(item1.getPrice()); item1.setProduct(item1.getProduct());
	 * item1.setQuantity(item1.getQuantity());
	 * 
	 * 
	 * CartItem item2 = new CartItem(20,700,product2,5);
	 * 
	 * List<CartItem> items= new ArrayList<CartItem>();
	 * 
	 * items.add(item1); items.add(item2);
	 * 
	 * Cart cart = new Cart();
	 * 
	 * cart.setCartId(cart.getCartId()); cart.setCartItems(cart.getCartitems());
	 * cart.setGrandTotal(cart.getGrandTotal());
	 * 
	 * Cart cart2 = new Cart(4,items,600d);
	 * 
	 * when(cartRepo.save(cart)).thenReturn(cart); }
	 */

	@Test
	public void test_updateQuantity() {

		Integer cartId = 5;
		Integer itemId = 7;
		Integer quantity = 9;

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

		Cart cart2 = new Cart(5, items, 200d);

		when(cartRepo.findById(cartId)).thenReturn(Optional.of(cart));
		String response = cartService.updateQuantity(cartId, itemId, quantity);

		assertEquals("updated successfully", response);
	}

	@Test
	public void testFailed_updateQuantity() {

		when(cartRepo.findById(8)).thenReturn(Optional.empty());
		String response = cartService.updateQuantity(8, 9, 10);

		assertEquals("Cart not Found", response);
	}

	@Test
	public void test_getSingleCart() {

		Integer cartId = 5;
		Integer itemId = 7;
		Integer quantity = 9;

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

		when(cartRepo.findById(cartId)).thenReturn(Optional.of(cart));

		Cart cartEx = cartService.getSingleCart(cartId);

		assertEquals(cart, cartEx);

	}

	@Test
	public void test_deleteItem() {
		Integer cartId = 5;
		Integer itemId = 7;
		Integer quantity = 9;

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

		when(cartRepo.findById(cartId)).thenReturn(Optional.of(cart));

		String res = cartService.deleteItem(cartId, itemId);

		assertEquals("deleted", res);

	}

	@Test
	public void testFailed_deleteItem() {
		when(cartRepo.findById(5)).thenReturn(Optional.empty());

		String res = cartService.deleteItem(5, 7);

		assertEquals("Cart not Found", res);

	}

	@Test
	public void addItem() {
		Integer cartId = 8;

		CartItemDto dto = new CartItemDto();

		dto.setCartItemId(7);
		dto.setProductId(10);
		dto.setQuantity(20);

		CartItemDto dto2 = new CartItemDto(40, 41, 42);

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

		Product product10 = new Product();
		product10.setCategory(product10.getCategory());
		product10.setDescription(product10.getDescription());
		product10.setDiscountedPrice(product10.getDiscountedPrice());
		product10.setProductId(product10.getProductId());
		product10.setProductName(product10.getProductName());
		product10.setProductRating(product10.getProductRating());
		product10.setProductReview(product10.getProductReview());
		product10.setQuantity(product10.getQuantity());
		product10.setRegularPrice(product10.getRegularPrice());

		Product product2 = new Product(8, "hp", "hhjjhj", 20, 900, 800, 2, "hghjhj", category2);

		when(restTemplate.getForObject("http://localhost:9093/products/" + dto.getProductId(), Product.class))
				.thenReturn(product1);

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

		when(cartRepo.findById(cartId)).thenReturn(Optional.of(cart));

		String res = cartService.addItem(cartId, dto);

		assertEquals("Cart Created Successfully", res);

	}

}
