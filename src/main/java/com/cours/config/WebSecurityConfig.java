package com.cours.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.cours.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationProvider provider;

	@Bean
	public AuthenticationProvider getProvider() {
		AppAuthProvider provider = new AppAuthProvider();
		provider.setUserDetailsService(userService);
		return provider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authenticationProvider(provider).authorizeRequests()
				.antMatchers(HttpMethod.GET, "/api/findById/*").authenticated().antMatchers(HttpMethod.DELETE, "/api/*")
				.hasAnyAuthority("SUPER").anyRequest().permitAll()

				.and().httpBasic();
	}
}

