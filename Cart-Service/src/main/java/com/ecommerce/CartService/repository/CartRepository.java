package com.ecommerce.CartService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.CartService.entity.Cart;

@Repository
public interface CartRepository extends MongoRepository<Cart, Integer> {

}
