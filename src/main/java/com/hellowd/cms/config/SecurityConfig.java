package com.hellowd.cms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @author SangHoon, Lee(devsh@helloworlds.co.kr)
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	public enum SecurityRole {

		ROLE_ADMIN, ROLE_USER
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/")
				.permitAll()
				.anyRequest()
				.authenticated();
		http.formLogin()
				.loginProcessingUrl("/login")
				.loginPage("/")
				.failureUrl("/?error")
				.defaultSuccessUrl("/main", true)
				.usernameParameter("username")
				.passwordParameter("password")
				.and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout**"))
				.logoutSuccessUrl("/").and().csrf().disable().httpBasic();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
				.antMatchers(HttpMethod.OPTIONS, "*//**")
				.antMatchers("/assets*//**")
				.antMatchers("/css*//**")
				.antMatchers("/fonts*//**")
				.antMatchers("/img*//**")
				.antMatchers("/js*//**")
				.antMatchers("/font-awesome*//**")
				.antMatchers("/robots.txt");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(AdminAuthenticationProvider());
	}

	@Bean(name = "AdminAuthenticationProvider")
	public AdminAuthenticationProvider AdminAuthenticationProvider() {
		return new AdminAuthenticationProvider();
	}


	@Bean
	public PasswordEncoder passwordEncoder() {
		return new ShaPasswordEncoder();
	}


	@Bean
	public SaltSource saltSource() {
		ReflectionSaltSource reflectionSaltSource = new ReflectionSaltSource();
		reflectionSaltSource.setUserPropertyToUse("username");
		return reflectionSaltSource;
	}

}

