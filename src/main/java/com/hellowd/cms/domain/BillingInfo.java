package com.hellowd.cms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author SangHoon, Lee(devsh@helloworlds.co.kr)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "billing_info")
public class BillingInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;

	@OneToOne
	@JoinColumn(name = "seq") // storeOwner.seq
	private StoreOwner storeOwner; // 가맹점주 정보

	@OneToMany(mappedBy = "billingInfo")
	private List<StoreCmsInfo> storeCmsInfoList = new ArrayList<>(); // 가맹점별 CMS 기본정보

	@OneToOne
	@JoinColumn(name = "seq") // payment.seq
	private Payment payment; // 결재 구분 (CMS | 카드)

	private int paymentType;

	private String withdrawDay; // 결제약정일

	private String withdrawPrice; // 기본결제금액 (가맹점별 Total)

	private Date withdrawStartDate; // 결제 시작일

	private Date withdrawEndDate; // 결제 종료일

	private String manager; // CMS 관리자

	private String contactNumber; // 가맹점주 연락처

	private int smsEnabled; // SMS 전송여부 (0:미전송 | 1:전송)

	private String cmsIdNo; // 예금주 주민등록상 생년월일(YYMMDD+SPACE(7) | 사업자번호 + SPACE(3))

	private String fileName; // 동의 서류 파일명

	private int cashRcptEnabled; // 현금영수증 발행여부 (0:미발행 | 1:발행)

	private String memo; // 메모

	private Date lastModifiedDate; // 마지막 수정일

	private Date lastFixedDate;  // 최종 출금일

//	public void addStoreCmsInfo(StoreCmsInfo storeCmsInfo) {
//		this.storeCmsInfoList.add(storeCmsInfo);
//		if (storeCmsInfo.getBillingInfo() != this) {
//			storeCmsInfo.setBillingInfo(this);
//		}
//	}
}
