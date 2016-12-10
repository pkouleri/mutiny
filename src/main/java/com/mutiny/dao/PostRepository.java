package com.mutiny.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mutiny.model.Post;

public interface PostRepository extends CrudRepository<Post, Integer> {

	@Query("select p from Post p where p.category.name in (:categories)")
	public List<Post> findByCategory(@Param("categories") List<String> categories);
}
