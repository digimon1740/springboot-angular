package com.hellowd.cms.domain.payment;

/**
 * @author SangHoon, Lee(devsh@helloworlds.co.kr)
 */
public interface Payment {

	int amount();

	boolean validate();
}
