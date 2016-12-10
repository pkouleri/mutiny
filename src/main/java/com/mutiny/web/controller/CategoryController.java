package com.mutiny.web.controller;

import com.mutiny.model.UserCategory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mutiny.dto.CategoryDto;
import com.mutiny.service.CategoryService;

import java.util.List;

@RestController
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@RequestMapping(path = "/category", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CategoryDto createCategory(@RequestBody CategoryDto categoryDto) {
		return categoryService.createCategory(categoryDto);
	}

	@RequestMapping(path = "/category", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CategoryDto getCategory(@RequestParam(name = "id", required = false) Integer id, @RequestParam(name = "name", required = false) String name) {
		if (StringUtils.isNotEmpty(name)) {
			return categoryService.findCategoryByName(name);
		} else {
			return categoryService.findCategory(id);
		}
	}

	@RequestMapping(path = "/user/{userId}/categories", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<UserCategory>> setUserCategories(@PathVariable long userId, @RequestBody List<String> categories, HttpSession session) {
		List<UserCategory> userCategories = categoryService.setUserCategories(categories, userId);
		if (userCategories == null) {
			return new ResponseEntity<List<UserCategory>>(userCategories, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<List<UserCategory>>(userCategories, HttpStatus.CREATED);
		}
	}

	@RequestMapping(path = "/user/{userId}/categories", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<String>> getUserCategories(@PathVariable long userId, HttpSession session) {
		List<String> userCategories = categoryService.getUserCategories(userId);
		if (userCategories == null) {
			return new ResponseEntity<List<String>>(userCategories, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<List<String>>(userCategories, HttpStatus.OK);
		}
	}
}
