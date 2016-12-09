package com.mutiny.web.controller;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mutiny.model.Account;

@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping(path = "/openid/login", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Account authenticateOpenId(@RequestParam String openIdUsername, @RequestParam String openIdEndpoint, @RequestParam String returnUrl,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		throw new NotImplementedException();
	}

	@RequestMapping(path = "/logout", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String logout(HttpSession session) {
		session.invalidate();
		return "/app/login";
	}

	@RequestMapping(path = "/{id}", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Account getUser(@PathVariable long userId, HttpSession session) {
		throw new NotImplementedException();
	}

}
