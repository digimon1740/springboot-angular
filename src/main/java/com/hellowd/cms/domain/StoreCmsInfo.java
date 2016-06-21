package com.hellowd.cms.domain;

import com.hellowd.cms.domain.payment.Payment;
import lombok.Data;

import java.util.List;

/**
 * @author SangHoon, Lee(devsh@helloworlds.co.kr)
 */
@Data
public class StoreCmsInfo {

	private long seq;

	private Store store;

	private List<StoreCmsHistory> storeCmsHistories;

	private Payment payment;

	private int paymentType;

	private String name;

	private int category;

	private int enabled;

}
