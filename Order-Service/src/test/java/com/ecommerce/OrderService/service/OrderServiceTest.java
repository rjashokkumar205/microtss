package com.ecommerce.OrderService.service;

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
import com.ecommerce.OrderService.repository.OrderRepository;

@SpringBootTest(classes = { OrderServiceTest.class })
public class OrderServiceTest {

	@Mock
	OrderRepository orderRepo;

	@Mock
	RestTemplate restTemplate;

	@InjectMocks
	OrderService orderService;

	@Test
	public void test_createOrder() {

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

		cart.setCartId(100);
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
		user2.setUserId(105);
		user2.setUserName("ffe");

		Card card = new Card();
		card.setCardCVV(1234);
		card.setCardNumber(222);
		card.setCardOwner("ffrwr");

		Card card2 = new Card(12, 34, "fdfhg");

		OrderDto orderDto = new OrderDto();
		orderDto.setOrderId("order123");
		orderDto.setCartId(100);
		orderDto.setUserId(105);
		orderDto.setPaymentMethods(Payment.CARDPAYMENT);
		orderDto.setCardDetails(card);
		orderDto.setShippingAddress(add);

		when(restTemplate.getForObject("http://localhost:9094/cart/" + orderDto.getCartId(), Cart.class))
				.thenReturn(cart);

		when(restTemplate.getForObject("http://localhost:9091/users/" + orderDto.getUserId(), User.class))
				.thenReturn(user2);

		Order order = new Order();
		order.setOrderId(orderDto.getOrderId());
		order.setCartDetails(cart);
		order.setUserDetails(user2);
		order.setCardDetails(card);
		order.setPaymentMethods(orderDto.getPaymentMethods());
		order.setShippingAddress(orderDto.getShippingAddress());

		when(orderRepo.insert(order)).thenReturn(order);

	}

	@Test
	public void test_getterSetters() {
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

		Address add10 = new Address();
		add10.setCity(add10.getCity());
		add10.setCountry(add10.getCountry());
		add10.setDistrict(add10.getDistrict());
		add10.setLine1(add10.getLine1());
		add10.setLine2(add10.getLine2());
		add10.setState(add10.getState());
		add10.setZipcode(add10.getZipcode());

		Order order10 = new Order();
		order10.setShippingAddress(order10.getShippingAddress());
		order10.setPaymentMethods(order10.getPaymentMethods());
		order10.setUserDetails(order10.getUserDetails());
		order10.setCardDetails(order10.getCardDetails());
		order10.setOrderDate(order10.getOrderDate());

		OrderDto dto10 = new OrderDto();
		dto10.setCardDetails(dto10.getCardDetails());

		User user10 = new User();
		user10.setAddress(user10.getAddress());
		user10.setEmail(user10.getEmail());
		user10.setPassword(user10.getPassword());
		user10.setPhone(user10.getPhone());
		user10.setUserId(user10.getUserId());
		user10.setUserName(user10.getUserName());
		user10.setCreatedOn(user10.getCreatedOn());

		Card card10 = new Card();
		card10.setCardCVV(card10.getCardCVV());
		card10.setCardNumber(card10.getCardNumber());
		card10.setCardOwner(card10.getCardOwner());

	}

	@Test
	public void test_getOrderByUserId() {

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

		Order order = new Order();
		order.setOrderId("order123");
		order.setCartDetails(cart);
		order.setUserDetails(user2);
		order.setCardDetails(card);
		order.setPaymentMethods(Payment.COD);
		order.setShippingAddress(user2.getAddress());

		List<Order> orders = new ArrayList<Order>();
		orders.add(order);

		when(orderRepo.findByUserDetailsUserId(12)).thenReturn(orders);
		assertEquals(orders, orderService.getOrderByUserId(12));
	}

	@Test
	public void test_getSingleOrder() {
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

		Address add2 = new Address("fgh", "hhgh", "ghjhhj", 9, "fghhg", "gyyguu", "ghhjjh");

		add.setLine1("fcd");
		add.setLine2("ef");
		add.setCity("sfvfs");
		add.setDistrict("dvvdv");
		add.setState("cdda");
		add.setCountry("scss");
		add.setZipcode(1234);

		User user1 = new User(1, "gghg", "ghh", "hgghh", add2, 10L);

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

		Order order = new Order();
		order.setOrderId("order123");
		order.setCartDetails(cart);
		order.setUserDetails(user2);
		order.setCardDetails(card);
		order.setPaymentMethods(Payment.CARDPAYMENT);
		order.setShippingAddress(add);

		when(orderRepo.findById("order123")).thenReturn(Optional.of(order));

		Order ord = orderService.getSingleOrder("order123");

		assertEquals(order, ord);
	}

}
