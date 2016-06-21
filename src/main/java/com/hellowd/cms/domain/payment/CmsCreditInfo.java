package com.hellowd.cms.domain.payment;

/**
 * @author SangHoon, Lee(devsh@helloworlds.co.kr)
 */
public class CmsCreditInfo implements Payment {
	@Override
	public int amount() {
		return 0;
	}

	@Override
	public boolean validate() {
		return false;
	}
}
