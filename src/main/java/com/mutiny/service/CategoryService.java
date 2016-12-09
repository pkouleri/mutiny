package com.mutiny.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mutiny.dao.CategoryRepository;
import com.mutiny.model.Category;

public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	public Category createCategory(String name) {
		return categoryRepository.save(new Category(name));
	}

	public Category findCategoryByName(String name) {
		return categoryRepository.findByName(name);
	}

}
