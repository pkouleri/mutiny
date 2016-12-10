package com.mutiny;

import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

//@Configuration
public class RestSecurityConfig /*extends WebSecurityConfigurerAdapter*/{

/*	@Override
	  protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off			
			http.antMatcher("/").authorizeRequests().antMatchers("/**","/account**", "/login**", "/webjars/**").permitAll().anyRequest()
			.authenticated().and().logout().logoutSuccessUrl("/").permitAll()and()..csrf()
			.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
	    http.csrf().disable();
	    
	    
	    // @formatter:on
	  }*/
}
