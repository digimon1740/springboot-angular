package com.hellowd.cms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * @author SangHoon, Lee(devsh@helloworlds.co.kr)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "store_cms_info")
public class StoreCmsInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;

	@ManyToOne
	@JoinColumn(name = "seq",insertable = false,updatable = false) // store.seq
	private Store store; // 가맹점 정보

	@ManyToOne
	@JoinColumn(name = "seq",insertable = false,updatable = false) // billingInfo.seq
	private BillingInfo billingInfo;

	@OneToMany(mappedBy = "storeCmsInfo")
	private List<StoreCmsHistory> storeCmsHistories; // CMS 결재이력 리스트

	private int paymentType;

	private int category; // 분류

	private int enabled; // 출금 상태 (0:비활성 | 1:활성)

	private Date lastModifiedDate; // 마지막 수정일
//
//	public void setBillingInfo(BillingInfo billingInfo) {
//		this.billingInfo = billingInfo;
//		if (!billingInfo.getStoreCmsInfoList().contains(this)) {
//			billingInfo.getStoreCmsInfoList().add(this);
//		}
//	}

}
