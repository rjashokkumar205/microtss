package com.ecommerce.ProductService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.ProductService.VO.Category;
import com.ecommerce.ProductService.VO.ResponseTemplateVO;
import com.ecommerce.ProductService.entity.Product;
import com.ecommerce.ProductService.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepo;
	
	@Autowired
    private RestTemplate restTemplate;

	public Product createProduct(Product product) {

		return productRepo.insert(product);
	}

	public ResponseTemplateVO getProductWithCategory(Integer productId) {
		
		 ResponseTemplateVO vo = new  ResponseTemplateVO();
		 Product product = productRepo.findByProductId(productId);
		 
		// Category category= restTemplate.getForObject("http://localhost:9001/categories/"+product.getCategoryId(), Category.class);
		
		 Category category = restTemplate.getForObject("http://localhost:9092/categories/" +product.getCategoryId(), Category.class);
		vo.setProductId(product.getProductId());
		vo.setProductName(product.getProductName());
		vo.setDescription(product.getDescription());
		vo.setDiscountedPrice(product.getDiscountedPrice());
		vo.setRegularPrice(product.getRegularPrice());
		vo.setQuantity(product.getQuantity());
		vo.setProductRating(product.getProductRating());
		vo.setProductReview(product.getProductReview());
		vo.setCategory(category);
		
		return vo;
	}

}
