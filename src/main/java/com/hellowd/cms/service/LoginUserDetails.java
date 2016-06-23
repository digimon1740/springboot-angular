package com.hellowd.cms.service;

import com.hellowd.cms.domain.Administrator;
import lombok.Data;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

/**
 * @author SangHoon, Lee(devsh@helloworlds.co.kr)
 */
@Data
public class LoginUserDetails extends User {

	private final Administrator user;

	public LoginUserDetails(Administrator user) {
		super(user.getEmail(), user.getPasswd(), AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
		this.user = user;
	}
}
