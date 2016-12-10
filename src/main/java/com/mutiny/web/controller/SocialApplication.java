package com.mutiny.web.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mutiny.dto.AccountDto;
import com.mutiny.service.AccountService;




@RestController
public class SocialApplication {
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping("/user")
	public AccountDto user(Principal principal) {
		OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
		Authentication userAuthentication = oAuth2Authentication.getUserAuthentication();
		String str = userAuthentication.getDetails().toString();
		
		
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
		return accountDto;
	}
	
	@RequestMapping(path= "/logout",method = { RequestMethod.POST })
	public void logout(HttpSession session) {
		session.invalidate();
	}


}