package com.mutiny.web.controller;

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

	@RequestMapping(path = "/user/{id}/categories", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Object setUserCategories(@PathVariable long userId, @RequestBody Object categories, HttpSession session) {
		throw new NotImplementedException();
	}

	@RequestMapping(path = "/user/{id}/categories", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Object getUserCategories(@PathVariable long userId, HttpSession session) {
		throw new NotImplementedException();
	}
}
