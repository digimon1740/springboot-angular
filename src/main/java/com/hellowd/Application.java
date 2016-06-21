package com.hellowd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableScheduling
public class Application {

	final static String[] ALLOWED_URLS = {"/index.html", "/"};

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * Spring Security Configuration
	 */
	@Configuration
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.httpBasic()
					.and()
					.authorizeRequests()
					.antMatchers(ALLOWED_URLS).permitAll()
					.anyRequest().authenticated();
		}
	}
}
