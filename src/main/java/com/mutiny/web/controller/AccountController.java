package com.mutiny.web.controller;

import java.security.Principal;
import java.util.Collection;
import java.util.LinkedHashMap;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.apache.http.protocol.BasicHttpContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
//import org.springframework.security.authentication.AbstractAuthenticationToken;
//import org.springframework.security.authentication.AnonymousAuthenticationToken;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.CredentialsContainer;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.oauth2.provider.OAuth2Authentication;
//import org.springframework.security.oauth2.provider.OAuth2Request;
//import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mutiny.dto.AccountDto;
import com.mutiny.service.AccountService;

@CrossOrigin(origins="http://localhost:8080")
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
	
	@RequestMapping("/user")
	public AccountDto user(Principal principal, HttpServletRequest request, HttpServletResponse response) {
		
/*		OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
		Authentication userAuthentication = oAuth2Authentication.getUserAuthentication();
		String str = userAuthentication.getDetails().toString();
		
		
		Boolean isNewuser = new Boolean(false);
		
		// persist account to db
		String name = str.substring((str.indexOf("name=")+"name=".length()), str.indexOf(","));
		String principalId = str.substring((str.indexOf("id=")+"id=".length()), str.indexOf("}"));
		
		AccountDto accountDto = accountService.findByPrincipal(principalId);
		if(accountDto == null){
			accountDto = new AccountDto();
			accountDto.setUsername(name);
			accountDto.setEmail("email@x.com");
			accountDto.setType("fb");
			accountDto.setPrincipal(principalId);
			
			accountDto.setIsNewUser(true);
			
			accountService.createAccount(accountDto);
			return  accountDto;
		}
		accountDto.setIsNewUser(false);
		return accountDto;*/
		
		return null;
	}
	
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
