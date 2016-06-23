package com.hellowd.cms.service;

import com.hellowd.cms.domain.Administrator;
import com.hellowd.cms.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author SangHoon, Lee(devsh@helloworlds.co.kr)
 */
@Service
public class LoginUserDetailsService implements UserDetailsService {

	@Autowired
	AdministratorRepository administratorRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Administrator user = administratorRepository.findOne(username);
		if (user == null) {
			throw new UsernameNotFoundException("The requested user is not found.");
		}
		return new LoginUserDetails(user);
	}
}
