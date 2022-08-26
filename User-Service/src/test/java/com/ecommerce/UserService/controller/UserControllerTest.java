package com.ecommerce.UserService.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ecommerce.UserService.entity.Address;
import com.ecommerce.UserService.entity.User;
import com.ecommerce.UserService.service.UserService;

@SpringBootTest(classes = { UserControllerTest.class })
public class UserControllerTest {

	@Mock
	UserService userService;

	@InjectMocks
	UserController userController;

	User user;

	@Test
	@Order(1)
	public void test_saveUser() {

		user = new User(1, "User1@gmail.com", "User1", "Pwd",
				new Address("line1", "line2", "city1", 1234, "dist", "state", "Country"), 401L);

		when(userService.createUser(user)).thenReturn(user);

		ResponseEntity<User> res = userController.saveUser(user);

		assertEquals(HttpStatus.CREATED, res.getStatusCode());

		assertEquals(user, res.getBody());
	}

	@Test
	public void test_listAllusers() {

		user = new User(1, "User1@gmail.com", "User1", "Pwd",
				new Address("line1", "line2", "city1", 1234, "dist", "state", "Country"), 401L);
		User user2 = new User();

		Address add = new Address();
		add.setCity("ffs");
		add.setCountry("fddf");
		add.setDistrict("ffg");
		add.setLine1("fdf");
		add.setLine2("ff");
		add.setState("ap");
		add.setZipcode(234);
		
		User user10 = new User();
		user10.setCreatedOn(user10.getCreatedOn());
		
		Address add10 = new Address();
		add10.setCity(add10.getCity());
		add10.setCountry(add10.getCountry());
		add10.setDistrict(add10.getDistrict());
		add10.setLine1(add10.getLine1());
		add10.setLine2(add10.getLine2());
		add10.setState(add10.getState());
		add10.setZipcode(add10.getZipcode());

		user2.setAddress(add);
		user2.setEmail("fefa");
		user2.setPassword("fsr");
		user2.setPhone(10L);
		user2.setUserId(123);
		user2.setUserName("ggrg");

		List<User> users = new ArrayList<User>();

		users.add(user);
		users.add(user2);

		when(userService.listUsers()).thenReturn(users);

		ResponseEntity<List<User>> res = userController.listAllUsers();

		assertEquals(HttpStatus.FOUND, res.getStatusCode());

		assertEquals(users, res.getBody());

	}

	@Test
	public void test_getUserById() {

		User user3 = new User(3, "User1@gmail.com", "User1", "Pwd",
				new Address("line1", "line2", "city1", 1234, "dist", "state", "Country"), 401L);
		when(userService.getSingleUser(3)).thenReturn(user3);

		ResponseEntity<User> res = userController.getUserById(3);

		assertEquals(HttpStatus.FOUND, res.getStatusCode());

		assertEquals(user3, res.getBody());

	}

	@Test
	public void test_deleteUser() {

		User user4 = new User(4, "User1@gmail.com", "User1", "Pwd",
				new Address("line1", "line2", "city1", 1234, "dist", "state", "Country"), 401L);
		when(userService.getSingleUser(4)).thenReturn(user4);

		ResponseEntity<User> res = userController.deleteUser(4);

		assertEquals(HttpStatus.OK, res.getStatusCode());

	}

	@Test
	public void test_updateUser() {

		Address add = new Address();
		add.setCity("ffs");
		add.setCountry("fddf");
		add.setDistrict("ffg");
		add.setLine1("fdf");
		add.setLine2("ff");
		add.setState("ap");
		add.setZipcode(234);

		User user5 = new User(5, "User1@gmail.com", "User5", "Pwd", add, 401L);
		when(userService.getSingleUser(5)).thenReturn(user5);

		when(userService.editUser(user5)).thenReturn(user5);

		ResponseEntity<User> res = userController.updateUser(5, user5);

		assertEquals(HttpStatus.OK, res.getStatusCode());

		assertEquals(5, res.getBody().getUserId());

		assertEquals("User5", res.getBody().getUserName());

		assertEquals("Pwd", res.getBody().getPassword());

		assertEquals(add, res.getBody().getAddress());

		assertEquals(401L, res.getBody().getPhone());

	}

}
