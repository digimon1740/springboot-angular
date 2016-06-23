package com.hellowd.cms.repository;

import com.hellowd.cms.domain.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator, String> {
	Administrator findByEmail(String email);
}