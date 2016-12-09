package com.mutiny.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mutiny.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

	@Query("select c from Category c where c.name = :name")
	public Category findByName(@Param("name") String name);
}
