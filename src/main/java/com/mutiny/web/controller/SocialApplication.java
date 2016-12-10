package com.mutiny.web.controller;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





public class SocialApplication/* extends WebSecurityConfigurerAdapter*/ {
	
//	public Principal user(Principal principal) {
//		return principal;
//	}

/*	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
	      .antMatcher("/**")
	      .authorizeRequests()
	        .antMatchers("/", "/login**", "/webjars/**")
	        .permitAll()
	      .anyRequest()
	        .authenticated();
	}
	
	@RequestMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}*/

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//	    .formLogin()
//	        .loginPage("/login") 
//	        .permitAll()
//	        .and()
//	    .authorizeRequests()
//	        .anyRequest()
//	        .authenticated(); 
//	}

//	public static void main(String[] args) {
//		SpringApplication.run(SocialApplication.class, args);
//	}

}