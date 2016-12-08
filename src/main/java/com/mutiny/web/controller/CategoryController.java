package com.mutiny.web.controller;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

	@RequestMapping(path = "/user/{id}/categories", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Object setUserCategories(@PathVariable long userId, @RequestBody Object categories, HttpSession session) {
		throw new NotImplementedException();
	}

	@RequestMapping(path = "/user/{id}/categories", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Object getUserCategories(@PathVariable long userId, HttpSession session) {
		throw new NotImplementedException();
	}
}
