package com.ecommerce.OrderService.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ecommerce.OrderService.entity.Address;
import com.ecommerce.OrderService.entity.Card;
import com.ecommerce.OrderService.entity.Cart;
import com.ecommerce.OrderService.entity.CartItem;
import com.ecommerce.OrderService.entity.Category;
import com.ecommerce.OrderService.entity.Order;
import com.ecommerce.OrderService.entity.OrderDto;
import com.ecommerce.OrderService.entity.Payment;
import com.ecommerce.OrderService.entity.Product;
import com.ecommerce.OrderService.entity.User;
import com.ecommerce.OrderService.service.OrderService;

@SpringBootTest(classes= {OrderControllerTest.class})
public class OrderControllerTest {
	
	@Mock
	OrderService orderService;
	
	@InjectMocks
	OrderController orderController;
	
	@Test
	public void test_saveOrder() {
		/*
		 * Category category = new Category();
		 * 
		 * category.setCategoryId(1); category.setCategoryName("mobiles");
		 * 
		 * Category category2 = new Category(2,"laptop");
		 * 
		 * Product product1= new Product();
		 * 
		 * product1.setCategory(category); product1.setDescription("fgsgsr");
		 * product1.setDiscountedPrice(700); product1.setProductId(45);
		 * product1.setProductName("vff"); product1.setProductRating(4);
		 * product1.setProductReview("bgbgd"); product1.setQuantity(100);
		 * product1.setRegularPrice(1200);
		 * 
		 * Product product2= new Product(3,"cdv","dfss",9,70,6,7,"rr",category2);
		 * 
		 * CartItem item1 = new CartItem(); item1.setCartItemId(10);
		 * item1.setProduct(product1); item1.setPrice(700); item1.setQuantity(4);
		 * 
		 * 
		 * CartItem item2 = new CartItem(); item1.setCartItemId(20);
		 * item1.setPrice(700); item1.setQuantity(4); item1.setProduct(product2);
		 * 
		 * List<CartItem> list = new ArrayList<CartItem>(); list.add(item1);
		 * list.add(item2);
		 * 
		 * Cart cart = new Cart(); cart.setCartId(123); cart.setCartItems(list);
		 * cart.setGrandTotal(190d);
		 * 
		 * 
		 * Address add = new Address();
		 * 
		 * Address add2 = new Address("dvds","sxss","sd",123,"caddd","sd","dc");
		 * 
		 * add.setLine1("fcd"); add.setLine2("ef"); add.setCity("sfvfs");
		 * add.setDistrict("dvvdv"); add.setState("cdda"); add.setCountry("scss");
		 * add.setZipcode(1234);
		 * 
		 * User user2 = new User(); user2.setAddress(add); user2.setEmail("dvfsv");
		 * user2.setPassword("dff"); user2.setPhone(10L); user2.setUserId(12);
		 * user2.setUserName("ffe");
		 * 
		 * Card card = new Card(); card.setCardCVV(1234); card.setCardNumber(222);
		 * card.setCardOwner("ffrwr");
		 */
	    
	    
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

		Address add = new Address();
		
		add.setLine1("fcd"); 
		add.setLine2("ef"); 
		add.setCity("sfvfs");
		add.setDistrict("dvvdv"); 
		add.setState("cdda"); 
		add.setCountry("scss");
		add.setZipcode(1234);
	    
		User user2 = new User();
		user2.setAddress(add); 
		user2.setEmail("dvfsv");
		user2.setPassword("dff");
		user2.setPhone(10L);
		user2.setUserId(12);
		 user2.setUserName("ffe");
		 
		 Card card = new Card();
		 card.setCardCVV(1234); 
		 card.setCardNumber(222);
		 card.setCardOwner("ffrwr");
	    
		
		OrderDto orderDto = new OrderDto();
		orderDto.setOrderId("order123");
		orderDto.setCartId(5);
		orderDto.setUserId(12);
		orderDto.setPaymentMethods(Payment.CARDPAYMENT);
		orderDto.setCardDetails(card);
		orderDto.setShippingAddress(add);
		
		
		Order order= new Order();
		order.setOrderId("order123");
		order.setCartDetails(cart);
		order.setUserDetails(user2);
		order.setCardDetails(card);
		order.setPaymentMethods(orderDto.getPaymentMethods());
		order.setShippingAddress(orderDto.getShippingAddress());
		
		when(orderService.createOrder(orderDto)).thenReturn(order);

		ResponseEntity<Order> res = orderController.saveOrder(orderDto);

		assertEquals(HttpStatus.CREATED, res.getStatusCode());

		assertEquals(order, res.getBody());

	}
	
	@Test
	public void test_getOrderByOrderId() {
		Order order= new Order();
		order.setOrderId("order123");
		order.setCartDetails(order.getCartDetails());
		order.setUserDetails(null);
		order.setCardDetails(null);
		order.setPaymentMethods(null);
		order.setShippingAddress(null);
		
		String orderId="order123";
		
		when(orderService.getSingleOrder(orderId)).thenReturn(order);
		ResponseEntity<Order> res = orderController.getOrderByOrderId(orderId);

		assertEquals(HttpStatus.FOUND, res.getStatusCode());

		assertEquals(orderId, res.getBody().getOrderId());

	}
	
	
	
	
	@Test
	public void test_getOrdersByUserId() {
		
		Order order1= new Order();
		order1.setOrderId("order1");
		order1.setCartDetails(null);
		order1.setUserDetails(null);
		order1.setCardDetails(null);
		order1.setPaymentMethods(null);
		order1.setShippingAddress(null);
		
		Order order2= new Order();
		order2.setOrderId("order2");
		order2.setCartDetails(null);
		order2.setUserDetails(null);
		order2.setCardDetails(null);
		order2.setPaymentMethods(null);
		order2.setShippingAddress(null);
		
		Order order3= new Order();
		order3.setOrderId("order3");
		order3.setCartDetails(null);
		order3.setUserDetails(null);
		order3.setCardDetails(null);
		order3.setPaymentMethods(null);
		order3.setShippingAddress(null);
		
		List<Order> orders = new ArrayList<Order>();
		
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		
		Integer userId=123;
		
		
		when(orderService.getOrderByUserId(userId)).thenReturn(orders);

		ResponseEntity<List<Order>> res = orderController.getOrdersByUserId(userId);

		assertEquals(HttpStatus.FOUND, res.getStatusCode());

		assertEquals(3, res.getBody().size());
		
	}
	
	

}
