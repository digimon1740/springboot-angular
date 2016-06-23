package com.hellowd.cms.service;

import com.hellowd.cms.domain.Administrator;
import com.hellowd.cms.repository.AdministratorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author SangHoon, Lee(devsh@helloworlds.co.kr)
 */
@Service
public class AdministratorService {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	AdministratorRepository administratorRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	SaltSource saltSource;

	public List<Administrator> findAll(){
		return administratorRepository.findAll();
	}

	public Administrator findByEmail(String email) {
		return administratorRepository.findByEmail(email);
	}

	@Transactional
	public Administrator save(Administrator administrator) {
//        List<ConstraintViolation> errors = ValidatorUtils.validate(administrator);
//        if( errors != null && errors.size() > 0 ) {
//            throw new ParameterValidateException(Administrator.class.toString(), errors.get(0).getMessage());
//        }

		try {
			Administrator result = administratorRepository.findByEmail(administrator.getEmail());
			String passwd;
			if(result==null)
				passwd = "";
			else
				passwd = result.getPasswd();

			if( passwd.isEmpty() ) {
				/**
				 *  new administrator passwd
				 */
				String encrypedPassword = encrypt(administrator.getEmail(), administrator.getPasswd());
				administrator.setPasswd(encrypedPassword);
			}
			else {
				if( !passwd.equals(administrator.getPasswd()) ) {
					/**
					 *  password change
					 */
					String encrypedPassword = encrypt(administrator.getEmail(), administrator.getPasswd());
					administrator.setPasswd(encrypedPassword);
				}
			}
			administrator.setMobile(administrator.getMobile().replace("-", ""));

			if( administrator.getLoginCount() == null )
				administrator.setLoginCount(0);

			if( administrator.getRegdate() == null )
				administrator.setRegdate(new Date());

			return administratorRepository.save(administrator);
		} catch (DataAccessException e) {
			logger.error(e.toString(), e);
			throw e;
		}
	}

	private String encrypt(String email, String password) {
		User user = new User(email, password,
				false, false, false, false, new LinkedList<GrantedAuthority>());

		return passwordEncoder.encodePassword(password, saltSource.getSalt(user));
	}

}
