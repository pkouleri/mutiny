package com.mutiny;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@EnableOAuth2Sso
@Configuration
public class RestSecurityConfig extends WebSecurityConfigurerAdapter{

@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http.antMatcher("/**")
				.authorizeRequests()
				.antMatchers("/", "/login**", "/webjars/**", "/account/**", "/post/**", "/category/**")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.logout()
				.logoutSuccessUrl("/")
				.permitAll()
				.and()
				.csrf()
				.disable();
		// @formatter:on
	}
}
