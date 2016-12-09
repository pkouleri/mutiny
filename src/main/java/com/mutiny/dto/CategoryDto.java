package com.mutiny.dto;

import com.mutiny.model.Category;

public class CategoryDto {

	Integer id;
	String name;

	public CategoryDto() {
	}

	public CategoryDto(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category toEntity() {
		return new Category(name);
	}

	public CategoryDto fromEntity(Category category) {
		return new CategoryDto(category.getId(), category.getName());
	}
}
