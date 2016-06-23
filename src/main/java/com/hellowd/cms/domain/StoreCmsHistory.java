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
import javax.persistence.Table;
import java.util.Date;

/**
 * @author SangHoon, Lee(devsh@helloworlds.co.kr)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "store_cms_history")
public class StoreCmsHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;

	@ManyToOne
	@JoinColumn(name = "seq",insertable = false,updatable = false) // storeCmsInfo.seq
	private StoreCmsInfo storeCmsInfo;  // 해당 가맹점 CMS 기본정보

	@ManyToOne
	@JoinColumn(name = "seq",insertable = false,updatable = false) // storeCmsInfo.seq
	private Payment payment; // 결재 구분 (CMS | 카드)

	private String withdrawPrice; // 해당 가맹점 결재금액

	private Date fixedDate; // 출금일

	private boolean defaultSuccess; // 기본 출금 성공여부 (0:실패 | 1:성공)

	private boolean firstSuccess; // 1차 출금 성공여부 (0:실패 | 1:성공)

	private boolean secondSuccess; // 2차 출금 성공여부 (0:실패 | 1:성공)

	private String failMessage; // 실패사

}
