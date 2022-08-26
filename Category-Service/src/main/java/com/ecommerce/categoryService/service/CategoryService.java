package com.ecommerce.categoryService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.categoryService.entity.Category;
import com.ecommerce.categoryService.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepo;

	public Category createCategory(Category category) {

		return categoryRepo.insert(category);
	}

	public List<Category> listCategories() {
		List<Category> categories= categoryRepo.findAll();
		return categories;

	}

	public Category findCategoryById(Integer categoryId) {

		Optional<Category> category = categoryRepo.findById(categoryId);
		
		if (category.isPresent()) {
			return category.get();	
		}
		
		return null;
		
	}

	public void deleteCategory(Category category) {

		categoryRepo.delete(category);

	}

	public Category editCategory(Category category) {

		return categoryRepo.save(category);

	}
}
