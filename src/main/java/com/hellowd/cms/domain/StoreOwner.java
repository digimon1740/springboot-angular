
package com.hellowd.cms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 * @author SangHoon, Lee(devsh@helloworlds.co.kr)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="s3_store_owner")
public class StoreOwner {

	public static final int TRANSFER_TYPE_BANK = 0; // 기본료 자동이체 납부
	public static final int TRANSFER_TYPE_CARD = 1;	// 기본료 카드 납부

	public static final int LOGIN_RESULT_OK 		= 0;
	public static final int LOGIN_RESULT_DUPLICATE 	= 1;
	public static final int LOGIN_RESULT_KICKFAIL 	= 2;
	public static final int LOGIN_RESULT_KICKTIMEOUT= 3;

	public static final int SIGN_UP_PATH_SEARCH 	= 0;
	public static final int SIGN_UP_PATH_CAFE 		= 1;
	public static final int SIGN_UP_PATH_INTRODUCED = 2;
	public static final int SIGN_UP_PATH_RECOMMEND 	= 3;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long seq;

	@Column(name="seller_seq")
	private Long sellerSeq;

//	@ManyToOne(fetch= FetchType.LAZY)
//	@JoinColumn(name="seller_seq", insertable=false, updatable=false)
//	private Seller seller;

	@OneToOne(mappedBy = "storeOwner")
	private BillingInfo billingInfo;

	@Column(name="ver")
	private String ver;

	@Column(name="id")
	private String id;

	@Column(name="passwd")
	private String passwd;

	@Column(name="name")
	private String name;

	@Column(name="cid_watch")
	private String cidWatch;

	@Column(name="cellnum")
	private String cellnum;

	@Column(name="busi_no")
	private String busiNo;

//	@OneToMany(mappedBy="owner", fetch= FetchType.LAZY)
//	private List<StoreEmployee> employees;

	@OneToMany(mappedBy="owner", fetch= FetchType.LAZY)
	private List<Store> stores;

//	@OneToMany(mappedBy="owner", fetch= FetchType.LAZY)
//	private List<StoreFixedFee> fixedFees;

	@Column(name="transfer_type")
	private int transferType;

	@Column(name="email")
	private String email;

	@Column(name="bank_no")
	private String bankNo;

	@Column(name="bank_name")
	private String bankName;

	@Column(name="bank_owner_name")
	private String bankOwnerName;

	@Column(name="card_no")
	private String cardNo;

	@Column(name="card_name")
	private String cardName;

	@Column(name="card_valid_year")
	private Integer cardValidYear;

	@Column(name="card_valid_month")
	private Integer cardValidMonth;

	@Column(name="billing")
	private int billing;

	@Column(name="transfer_date")
	private int transferDate;	// 이체실행일

	@Column(name="fixed_fee_non_pay_sum")
	private int fixedFeeNonPaySum;		// 기본료 체납액 합계

	@Column(name="settlement_non_pay_sum")
	private int settlementNonPaySum;	// 마이너스 정산금 합계(현금 주문시 발생)

	@Column(name="login_count")
	private long loginCount;

	@Column(name="last_login_date")
	private Date lastLoginDate;

	@Column(name="sign_up_path")
	private Integer signUpPath;

	@Column(name="recommend")
	private int recommend;

	@Column(name="cancel_confirm")
	private int cancelConfirm;

	@Column(name="use_operation")
	private int useOperation;

	@Column(name="regdate")
	private Date regdate;

	//	@Column(name="mergeAddress")
	@Transient
	private String mergeAddress;

	//-- 배달대행 업체
//	@ManyToMany(fetch= FetchType.LAZY)
//	@JoinTable(name="delvagent_corp_store_owner", joinColumns=@JoinColumn(name="owner_seq"), inverseJoinColumns=@JoinColumn(name="delvagent_corp_seq"))
//	private Set<DelvagentCorp> delvagentCorps;
	//--

	//birthDate추가
	@Column(name="birthdate")
	private String birthDate;

	//register_waiting
	@Column(name="register_waiting",columnDefinition = "int(11) default='1'")
	private int registerWaiting;

	//register_memo
	@Column(name="register_memo")
	private String registerMemo;

//	@XmlElementWrapper(name="Stores")
//	@XmlElement(name="Store")
//	@Transient
//	private List<Store> representStores;

	//-- 로그인시 사용한 APP의 종류를 지정한다.
	@Column(name="app_type")
	private String appType;

	@Transient
	private String storeName;
	@Transient
	private String procDt;
	@Transient
	private String fee;

	@Override
	public String toString() {
		return "{" +
				"appType='" + appType + '\'' +
				", seq=" + seq +
				", sellerSeq=" + sellerSeq +
				", ver='" + ver + '\'' +
				", id='" + id + '\'' +
				", passwd='" + passwd + '\'' +
				", name='" + name + '\'' +
				", cidWatch='" + cidWatch + '\'' +
				", cellnum='" + cellnum + '\'' +
				", busiNo='" + busiNo + '\'' +
				", transferType=" + transferType +
				", email='" + email + '\'' +
				", bankNo='" + bankNo + '\'' +
				", bankName='" + bankName + '\'' +
				", bankOwnerName='" + bankOwnerName + '\'' +
				", cardNo='" + cardNo + '\'' +
				", cardName='" + cardName + '\'' +
				", cardValidYear=" + cardValidYear +
				", cardValidMonth=" + cardValidMonth +
				", billing=" + billing +
				", transferDate=" + transferDate +
				", fixedFeeNonPaySum=" + fixedFeeNonPaySum +
				", settlementNonPaySum=" + settlementNonPaySum +
				", loginCount=" + loginCount +
				", lastLoginDate=" + lastLoginDate +
				", signUpPath=" + signUpPath +
				", recommend=" + recommend +
				", cancelConfirm=" + cancelConfirm +
				", useOperation=" + useOperation +
				", regdate=" + regdate +
				", mergeAddress='" + mergeAddress + '\'' +
				", birthDate='" + birthDate + '\'' +
				", registerWaiting=" + registerWaiting +
				", registerMemo='" + registerMemo + '\'' +
				'}';
	}
}
