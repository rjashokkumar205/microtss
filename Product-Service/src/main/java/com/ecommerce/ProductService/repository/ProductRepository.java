package com.ecommerce.ProductService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ProductService.entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product,Integer> {
	Product findByProductId(Integer productId);
}
