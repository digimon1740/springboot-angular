package com.hellowd.cms.domain;

import com.hellowd.cms.domain.payment.Payment;
import lombok.Data;

import java.util.Date;

/**
 * @author SangHoon, Lee(devsh@helloworlds.co.kr)
 */
@Data
public class StoreCmsHistory {

	private long seq;

	private StoreCmsInfo storeCmsInfo;

	private Payment payment;

	private String withdrawPrice;

	private Date fixedDate;

	private boolean defaultSuccess;

	private boolean firstSuccess;

	private boolean secondSuccess;

	private String failMessage;
	
}
