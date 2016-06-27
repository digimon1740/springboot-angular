package com.hellowd.cms.config;

import com.hellowd.cms.domain.Administrator;
import com.hellowd.cms.service.AdministratorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.LinkedList;

public class AdminAuthenticationProvider implements AuthenticationProvider {

	Logger logger = LoggerFactory.getLogger(getClass());

	public static final String AUTH_STORE_OWNER = "STORE_OWNER";

	@Autowired
	AdministratorService administratorService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private SaltSource saltSource;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String id = authentication.getName();
		String password = (String) authentication.getCredentials();

		Administrator administrator;
		Collection<? extends GrantedAuthority> authorities;

		try {
			if (StringUtils.isEmpty(id) || StringUtils.isEmpty(password)) {
				throw new BadCredentialsException("Username/Password entered is incorrect");
			}

			User user =
					new User(id, password,
							false, false, false, false, new LinkedList<GrantedAuthority>());
			administrator = administratorService.findByEmail(id);
			if (administrator == null) {
				throw new BadCredentialsException("The requested user is not found.");
			}
			String encryptedPassword = passwordEncoder.encodePassword(password, saltSource.getSalt(user));

			if (!encryptedPassword.equals(administrator.getPasswd()))
				throw new BadCredentialsException("Invalid user password");
			authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(AUTH_STORE_OWNER);

		} catch (UsernameNotFoundException e) {
			logger.info(e.toString());
			throw new UsernameNotFoundException(e.getMessage());
		} catch (BadCredentialsException e) {
			logger.info(e.toString());
			throw new BadCredentialsException(e.getMessage());
		} catch (Exception e) {
			logger.info(e.toString());
			throw new RuntimeException(e.getMessage());
		}

		return new UsernamePasswordAuthenticationToken(id, password, authorities);
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return true;
	}

}
