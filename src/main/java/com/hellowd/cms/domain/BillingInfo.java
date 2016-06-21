package com.hellowd.cms.domain;

import com.hellowd.cms.domain.payment.Payment;
import lombok.Data;

import java.util.Date;

/**
 * @author SangHoon, Lee(devsh@helloworlds.co.kr)
 */
@Data
public class BillingInfo {

	private long seq;

	private StoreOwner storeOwner;

	private StoreCmsInfo storeCmsInfo;

	private Payment payment;

	private int paymentType;

	private String withdrawDay;

	private String withdrawPrice;

	private Date withdrawStartDate;

	private Date withdrawEndDate;

	private String manager;

	private String contactNum;

	private int smsEnabled;

	private String cmsIdNo;

	private String fileName;

	private int cashRcptEnabled;

	private String memo;

	private Date lastModifiedDate;

	private Date lastWithdrawDate;


}
