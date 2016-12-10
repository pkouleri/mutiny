package com.mutiny.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mutiny.dao.CategoryRepository;
import com.mutiny.dto.CategoryDto;
import com.mutiny.model.Category;

@Component
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category = categoryRepository.save(categoryDto.toEntity());
		return new CategoryDto().fromEntity(category);
	}

	public CategoryDto findCategoryByName(String name) {
		Category category = categoryRepository.findByNameIgnoreCase(name);
		return new CategoryDto().fromEntity(category);
	}

	public CategoryDto findCategory(Integer id) {
		Category category = categoryRepository.findOne(id);
		return new CategoryDto().fromEntity(category);
	}
}
