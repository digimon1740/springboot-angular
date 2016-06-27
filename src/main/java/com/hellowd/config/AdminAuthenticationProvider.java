package com.hellowd.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;

public class AdminAuthenticationProvider implements AuthenticationProvider {

	Logger logger = LoggerFactory.getLogger(getClass());

	public static final String AUTH_STORE_OWNER = "STORE_OWNER";

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private SaltSource saltSource;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String id = authentication.getName();
		String password = (String) authentication.getCredentials();

		Collection<? extends GrantedAuthority> authorities;


		authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(AUTH_STORE_OWNER);

		return new UsernamePasswordAuthenticationToken(id, password, authorities);
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return true;
	}

}
