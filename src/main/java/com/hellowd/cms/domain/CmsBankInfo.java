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
@DiscriminatorValue("B")
public class CmsBankInfo extends Payment {

	@Column(name = "bank_code")
	private String bankCode;

	@Column(name = "bank_account_name")
	private String accountName;

	@Column(name = "bank_account_number")
	private String accountNum;

	@Override
	public int amount() {
		return 0;
	}

	@Override
	public boolean validate() {
		return false;
	}
}
