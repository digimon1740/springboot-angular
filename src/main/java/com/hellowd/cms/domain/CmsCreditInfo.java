package com.hellowd.cms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author SangHoon, Lee(devsh@helloworlds.co.kr)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("C")
public class CmsCreditInfo extends Payment {

	@Column(name = "credit_number")
	private String number;

	@Column(name = "credit_year")
	private String year;

	@Column(name = "credit_month")
	private String month;

	@Column(name = "credit_passwd")
	private String password;

	@Override
	public int amount() {
		return 0;
	}

	@Override
	public boolean validate() {
		return false;
	}
}
