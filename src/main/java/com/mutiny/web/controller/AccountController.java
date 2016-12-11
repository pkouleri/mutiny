package com.mutiny.web.controller;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mutiny.dto.AccountDto;
import com.mutiny.service.AccountService;

//@CrossOrigin(origins="http://localhost:8080")
@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService accountService;

	@RequestMapping(path = "/openid/login", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public AccountDto authenticateOpenId(@RequestParam String openIdUsername, @RequestParam String openIdEndpoint, @RequestParam String returnUrl,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		throw new NotImplementedException();
	}

	@RequestMapping(path = "/logout", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String logout(HttpSession session) {
		session.invalidate();
		return "/app/login";
	}

	@RequestMapping(path = "/{id}", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public AccountDto getAccount(@PathVariable Integer id, HttpSession session) {
		return accountService.getAccount(id);
	}

	@RequestMapping(path = "/{id}",method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public AccountDto createAccount(@RequestBody AccountDto accountDto) {
		return accountService.createAccount(accountDto);
	}
	
//	@RequestMapping("/user")
//	public AccountDto user(Principal principal, HttpServletRequest request, HttpServletResponse response) {
//		
//		OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
//		Authentication userAuthentication = oAuth2Authentication.getUserAuthentication();
//		String str = userAuthentication.getDetails().toString();
//		
//		
//		Boolean isNewuser = new Boolean(false);
//		
//		// persist account to db
//		String name = str.substring((str.indexOf("name=")+"name=".length()), str.indexOf(","));
//		String principalId = str.substring((str.indexOf("id=")+"id=".length()), str.indexOf("}"));
//		
//		AccountDto accountDto = accountService.findByPrincipal(principalId);
//		if(accountDto == null){
//			accountDto = new AccountDto();
//			accountDto.setUsername(name);
//			accountDto.setEmail("email@x.com");
//			accountDto.setType("fb");
//			accountDto.setPrincipal(principalId);
//			
//			accountDto.setIsNewUser(true);
//			
//			accountService.createAccount(accountDto);
//			return  accountDto;
//		}
//		accountDto.setIsNewUser(false);
//		return accountDto;
//		
//	}
	
	
	
	private Cookie createCookie(String cookieName, String cookieValue) {
	    Cookie cookie = new Cookie(cookieName, cookieValue);
	    cookie.setPath("/");
	    cookie.setMaxAge(Integer.MAX_VALUE);
	    cookie.setHttpOnly(true);
	    cookie.setSecure(true);
	    return cookie;
	}
	
/*	public static void main(String[] args) {
		String str = "{name= soulee, ffdsfd=sdvvv}";
		
		str.substring((str.indexOf("name=")+"name=".length()), str.indexOf(","));
		
	}*/

		
}
