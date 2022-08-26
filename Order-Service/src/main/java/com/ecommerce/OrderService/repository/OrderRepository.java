package com.ecommerce.OrderService.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.OrderService.entity.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

	List<Order> findByUserDetailsUserId(Integer userId);

}
