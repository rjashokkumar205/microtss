package com.ecommerce.UserService.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.UserService.controller.UserControllerTest;
import com.ecommerce.UserService.entity.Address;
import com.ecommerce.UserService.entity.User;
import com.ecommerce.UserService.repository.UserRepository;

@SpringBootTest(classes = { UserServiceTest.class })
public class UserServiceTest {
	
	@Mock
	UserRepository userRepo;
	
	@InjectMocks
	UserService userService;
	
	@Test
	public void test_createUser() {
		
	User	user = new User(1, "User1@gmail.com", "User1", "Pwd",
				new Address("line1", "line2", "city1", 1234, "dist", "state", "Country"), 401L);

	
	when(userRepo.insert(user)).thenReturn(user);
	
	assertEquals(user,userService.createUser(user));}
	
	
	@Test
	public void test_listUsers() {
		
		User	user1 = new User(1, "User1@gmail.com", "User1", "Pwd",
				new Address("line1", "line2", "city1", 1234, "dist", "state", "Country"), 401L);

	
		
		User	user2 = new User(2, "User2@gmail.com", "User2", "Pwd2",
				new Address("line1", "line2", "city1", 1234, "dist", "state", "Country"), 201L);
		
		List<User> users = new ArrayList<User>();
		
		users.add(user1);
		users.add(user2);
		
		when(userRepo.findAll()).thenReturn(users);
		
		assertEquals(2,userService.listUsers().size());
		
		
	}
	
	@Test
	public void test_getSingleUser() {
		
		
		
		User	user1 = new User(1, "User1@gmail.com", "User1", "Pwd",
				new Address("line1", "line2", "city1", 1234, "dist", "state", "Country"), 401L);

		
		when(userRepo.findById(1)).thenReturn(Optional.of(user1));

		assertEquals(user1, userService.getSingleUser(1));

	}
	
	
	@Test
	public void test_editUser() {
		
		User	user1 = new User(1, "User1@gmail.com", "User1", "Pwd",
				new Address("line1", "line2", "city1", 1234, "dist", "state", "Country"), 401L);

		
		when(userRepo.save(user1)).thenReturn(user1);
		
		assertEquals(user1, userService.editUser(user1));

		
	}
	

}
