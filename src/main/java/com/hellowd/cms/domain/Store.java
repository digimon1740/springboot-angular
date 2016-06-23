
package com.hellowd.cms.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

/**
 * @author SangHoon, Lee(devsh@helloworlds.co.kr)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "s3_store")
public class Store {

	@Transient
	private Logger logger = LoggerFactory.getLogger(getClass());

	public final static String UUID = "Store";

	public static final String STORE_LOGO_IMAGE = "storeLogoImage";
	public static final String STORE_PAPER_IMAGE = "storePaperImage";

	public final static int STATUS_OPEN = 0; // 영업중(정확하게는 가맹점 관리 프로그램이 서버와 연결되어 있는 상태를 의미한다. 정확한 영업시간 확인 isOff 메소드를 사용한다.)
	public final static int STATUS_CLOSE = 1; // 영업종료
	public final static int STATUS_OFF = 2; // 휴일
	public final static int STATUS_ABSENT = 3; // 부재중
	public final static int STATUS_WAIT = 4; // 대기중

	public final static int SUPPORT_ALL = 0; // 모두지원
	public final static int SUPPORT_EPS = 1; // 전자결제지원
	public final static int SUPPORT_CALL = 2; // 콜링크지원

	public final static int COMMISSION_NONE = 0; // 커미션 적용하지 않음
	public final static int COMMISSION_ORDER_RATE = 1; // 주문당 수수료 부과
	public final static int COMMISSION_ORDER_FIXED = 2; // 주문당 일정금액 부과

	public final static int OFF_WEEK_REPEAT = 99;    // 매주
	public final static int OFF_WEEK_ODD = 135;    // 1,3,5주
	public final static int OFF_WEEK_EVEN = 246;    // 2,4,6주
	public final static int OFF_WEEK_CUSTOME = 10;    // 지정된주

	private final static String[] DAYNAME = {"일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일", ""};

	public final static String DEAD_POOL_NUMBER = "020000000";

	//감춤 사유
	public final static int HIDDEN = 0; //일반
	public final static int HIDDEN_HOLIDAY = 1; //휴일
	public final static int HIDDDEN_DELETED = 2; // 삭제됨

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;

	@Column(name = "owner_seq")
	private Long ownerSeq;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "owner_seq", insertable = false, updatable = false)
	private StoreOwner owner;

	@Column(name = "mobile_service_seq")
	private Long mobileServiceSeq;


	@Column(name = "support_type")
	private int supportType;

	@Column(name = "free")
	private int free;

	@Column(name = "virtual")
	private int virtual;

	@Column(name = "name")
	private String name;

	@Column(name = "use_bizapp")
	private int useBizapp; // 철가방비즈앱사용여부

	@Column(name = "use_tts")
	private int useTTS; // TTS사용여부

	@Column(name = "notify_tts_only")
	private int notifyTtsOnly; // 철가방비즈앱 또는 TTS사용시 가맹점 관리 프로그램을 사용하지 않을 수 있다.

	@Column(name = "telnum")
	private String telnum;    // 매정 전화(로그인 아이디)

	@Column(name = "vtelnum")
	private String vtelnum;    // 가상번호

	@Column(name = "cellnum")
	private String cellnum;    // 대표자 연락처

	@Column(name = "bizapp_assist_num")
	private String bizappAssistNum; // 철가방비즈앱 보조 연락처

	@Column(name = "ttsnum")
	private String ttsnum;

	@Column(name = "ceo")
	private String ceo;

	@Column(name = "email")
	private String email;

	@Column(name = "category")
	private int category;

	@Column(name = "status")
	private int status;

	@Column(name = "cid_watch")
	private String cidWatch;

	@Column(name = "push_host_port")
	private String pusHostPort;

	@Column(name = "hidden")
	private int hidden;

	@Column(name = "runtime")
	private String runtime;        // 영업시간 HH:mm~HH:mm

	@Column(name = "run24")
	private int run24;            // 24시 영업

	@Column(name = "open_time")
	private int openTime;        // 오픈시간(단위 분)

	@Column(name = "close_time")
	private int closeTime;        // 마감시간(단위 분)

	@Column(name = "no_close")
	private int noclose;

	@Column(name = "offweek")
	private int offweek;

	@Column(name = "offday")
	private int offday;

	@Column(name = "tmp_offdaay_start")
	private Date tmpOffdayStart;

	@Column(name = "tmp_offday_end")
	private Date tmpOffdayEnd;

	@Column(name = "delvable")
	private String delvable;

	@Column(name = "delvable_replace")
	private String delvableReplace;

	@Column(name = "delv_min_price")
	private int delvMinPrice;

	@Column(name = "comment")
	private String comment;

	//----------------------------------------------------------
	//-- 주소관련 필드
	//----------------------------------------------------------
	@Column(name = "address")
	private String address; //-- 일부 전화 가맹점외에 사용되지 않음.

	@Column(name = "sido")
	private String sido; //-- 시/도

	@Column(name = "gugun")
	private String gugun; //-- 시군구

	@Column(name = "dong")
	private String dong; //-- 읍면동

	@Column(name = "bunji")
	private String bunji; //-- 번지

	@Column(name = "ri")
	private String ri; //-- 리

	@Column(name = "addr_legacy")
	private String addrLegacy; //-- 지번주소

	@Column(name = "addr_road")
	private String addrRoad; //-- 도로명주소

	@Column(name = "bldg_name")
	private String buildingName; //-- 건물명

	@Column(name = "zipcode")
	private String zipcode; //- 우편번호

	@Column(name = "zonecode")
	private String zonecode; //-- 새로운 우편번호

	@Column(name = "etcaddr")
	private String etcaddr; //-- 기타 주소

	@Column(name = "gpslat")
	private String gpslat;

	@Column(name = "gpslng")
	private String gpslng;
	//----------------------------------------------------------

	@Column(name = "bank_no")
	private String bankNo;

	@Column(name = "bank_name")
	private String bankName;

	@Column(name = "bank_owner_name")
	private String bankOwnerName;

	@Column(name = "franchise_type_seq")
	private Long franchiseTypeSeq;

	@Column(name = "commission_type")
	private int commissionType;

	@Column(name = "commission")
	private double commission;

	@Column(name = "charge_pay_commission")
	private int chargePayCommission;

	@Column(name = "paynow_commision")
	private Double paynowCommission;

	@Column(name = "fast_paynow_commision")
	private Double fastPaynowCommission;

	@Column(name = "fixed_fee")
	private int fixedFee;

	@Column(name = "salerate")
	private double salerate;

	@Column(name = "book_discount")
	private int bookDiscount;

	@Column(name = "book_discount_balance")
	private long bookDiscountBalance;

	@Column(name = "book_discount_rate")
	private double bookDiscountRate;

	@Column(name = "book_discount_start_date")
	private Date bookDiscountStartDate;

	@Column(name = "book_discount_end_date")
	@XmlElement
	private Date bookDiscountEndDate;

	@Column(name = "seller_seq")
	private Long sellerSeq;

//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="seller_seq", insertable=false, updatable=false)
//	private Seller seller;

	@Column(name = "call_count")
	private long callCount;

	@Column(name = "order_complete_count")
	private long orderCompleteCount;

	@Column(name = "estimate_count")
	private long estimateCount;

	@Column(name = "estimate_reply_count")
	private long estimateReplyCount;

	@Column(name = "estimate_sum")
	private int estimateSum;

	@Column(name = "shop_logo_image")
	private String logoImage;

	@Column(name = "shop_paper_image")
	private String paperImage;

	@Column(name = "memo")
	private String memo;

	@Column(name = "send_sms_count")
	private long sendSmsCount;

	@Column(name = "free_service_expired_date")
	private Date freeServiceExpiredDate;

	@Column(name = "regdate")
	private Date regdate;

	@Column(name = "mobile_page_name")
	private String mobilePageName;            // 모바일 홈페이지 명

	@Column(name = "contract_term_from")
	private Date contractTermFrom;            // 모바일 홈페이지 계약기간 from

	@Column(name = "contract_term_to")
	private Date contractTermTo;            // 모바일 홈페이지 계약기간 to

	@Column(name = "activate_status")
	private int activateStatus;            // 모바일 홈페이지 활성화 여부	false : 0, true : 1

	@Column(name = "mobile_status")
	private int mobileStatus;            // 모바일 홈페이지 구분	false : 0, true : 1

	@Column(name = "uplus_promo")
	private int uplusPromo;

	@Column(name = "owner_take_commission")
	private int ownerTakeCommission;        // 현물 책자 할인 정산 금액 수취인(0 : 지역사업자, 1 : 가맹점주)

	@Column(name = "test_store")
	private int testStore;

	@Column(name = "use_cms")
	private Integer useCMS;

	@Column(name = "cms_type")
	private Integer cmsType;

	@Column(name = "cms_transfer_date")
	private Date cmsTransferDate;

	@Column(name = "cms_account")
	private String cmsAccount;

	@Column(name = "cms_account_value")
	private String cmsAccountValue;

	@Column(name = "cms_account_bank")
	private String cmsAccountBank;

	@Column(name = "cms_account_owner_name")
	private String cmsAccountOwnerName;

	@Column(name = "cms_account_verify_info")
	private String cmsAccountVerifyInfo;

	@Column(name = "cms_withdraw_day")
	private String cmsWithdrawDay;

	@Column(name = "display_order")
	@XmlElement
	private int displayOrder;

	@Column(name = "vtel_call_count")
	private long vtelCallCount;

	//register_waiting
	@Column(name = "register_waiting", columnDefinition = "int(11) default='1'")
	private int registerWaiting;

	//register_memo
	@Column(name = "register_memo")
	private String registerMemo;

	//hide reason
	@Column(name = "hide_reason")
	private int hideReason;

	@Transient
	private String cmsTypeString;

	@Transient
	private String cmsAccountBankString;

	@Transient
	private Long delvagentSeq;

	@Transient
	private String withdrawDay;

	@Transient
	private String withdrawnYN;

	@Transient
	private String fmsAccountCount;

	public String getHideReasonString() {
		String status;
		switch (hideReason) {

			case 1:
				status = "휴무";
				break;
			case 2:
				status = "삭제";
				break;
			default:
				status = "일반";
				break;
		}
		return status;
	}

	@Override
	public String toString() {
		return "Store{" +
				"activateStatus=" + activateStatus +
				", seq=" + seq +
				", ownerSeq=" + ownerSeq +
				", owner=" + owner +
				", mobileServiceSeq=" + mobileServiceSeq +
				", supportType=" + supportType +
				", free=" + free +
				", virtual=" + virtual +
				", name='" + name + '\'' +
				", useBizapp=" + useBizapp +
				", useTTS=" + useTTS +
				", notifyTtsOnly=" + notifyTtsOnly +
				", telnum='" + telnum + '\'' +
				", vtelnum='" + vtelnum + '\'' +
				", cellnum='" + cellnum + '\'' +
				", bizappAssistNum='" + bizappAssistNum + '\'' +
				", ttsnum='" + ttsnum + '\'' +
				", ceo='" + ceo + '\'' +
				", email='" + email + '\'' +
				", category=" + category +
				", status=" + status +
				", cidWatch='" + cidWatch + '\'' +
				", pusHostPort='" + pusHostPort + '\'' +
				", hidden=" + hidden +
				", runtime='" + runtime + '\'' +
				", run24=" + run24 +
				", openTime=" + openTime +
				", closeTime=" + closeTime +
				", noclose=" + noclose +
				", offweek=" + offweek +
				", offday=" + offday +
				", tmpOffdayStart=" + tmpOffdayStart +
				", tmpOffdayEnd=" + tmpOffdayEnd +
				", delvable='" + delvable + '\'' +
				", delvableReplace='" + delvableReplace + '\'' +
				", delvMinPrice=" + delvMinPrice +
				", comment='" + comment + '\'' +
				", address='" + address + '\'' +
				", sido='" + sido + '\'' +
				", gugun='" + gugun + '\'' +
				", dong='" + dong + '\'' +
				", bunji='" + bunji + '\'' +
				", ri='" + ri + '\'' +
				", addrLegacy='" + addrLegacy + '\'' +
				", addrRoad='" + addrRoad + '\'' +
				", buildingName='" + buildingName + '\'' +
				", zipcode='" + zipcode + '\'' +
				", zonecode='" + zonecode + '\'' +
				", etcaddr='" + etcaddr + '\'' +
				", gpslat='" + gpslat + '\'' +
				", gpslng='" + gpslng + '\'' +
				", bankNo='" + bankNo + '\'' +
				", bankName='" + bankName + '\'' +
				", bankOwnerName='" + bankOwnerName + '\'' +
				", franchiseTypeSeq=" + franchiseTypeSeq +
				", commissionType=" + commissionType +
				", commission=" + commission +
				", chargePayCommission=" + chargePayCommission +
				", paynowCommission=" + paynowCommission +
				", fastPaynowCommission=" + fastPaynowCommission +
				", fixedFee=" + fixedFee +
				", salerate=" + salerate +
				", bookDiscount=" + bookDiscount +
				", bookDiscountBalance=" + bookDiscountBalance +
				", bookDiscountRate=" + bookDiscountRate +
				", bookDiscountStartDate=" + bookDiscountStartDate +
				", bookDiscountEndDate=" + bookDiscountEndDate +
				", sellerSeq=" + sellerSeq +
				", callCount=" + callCount +
				", orderCompleteCount=" + orderCompleteCount +
				", estimateCount=" + estimateCount +
				", estimateReplyCount=" + estimateReplyCount +
				", estimateSum=" + estimateSum +
				", logoImage='" + logoImage + '\'' +
				", paperImage='" + paperImage + '\'' +
				", memo='" + memo + '\'' +
				", sendSmsCount=" + sendSmsCount +
				", freeServiceExpiredDate=" + freeServiceExpiredDate +
				", regdate=" + regdate +
				", mobilePageName='" + mobilePageName + '\'' +
				", contractTermFrom=" + contractTermFrom +
				", contractTermTo=" + contractTermTo +
				", mobileStatus=" + mobileStatus +
				", uplusPromo=" + uplusPromo +
				", ownerTakeCommission=" + ownerTakeCommission +
				", testStore=" + testStore +
				", useCMS=" + useCMS +
				", cmsType=" + cmsType +
				", cmsTransferDate=" + cmsTransferDate +
				", cmsAccount='" + cmsAccount + '\'' +
				", cmsAccountValue='" + cmsAccountValue + '\'' +
				", cmsAccountBank='" + cmsAccountBank + '\'' +
				", cmsAccountOwnerName='" + cmsAccountOwnerName + '\'' +
				", cmsAccountVerifyInfo='" + cmsAccountVerifyInfo + '\'' +
				", cmsWithdrawDay='" + cmsWithdrawDay + '\'' +
				", displayOrder=" + displayOrder +
				", vtelCallCount=" + vtelCallCount +
				", registerWaiting=" + registerWaiting +
				", registerMemo='" + registerMemo + '\'' +
				", hideReason=" + hideReason +
				", cmsTypeString='" + cmsTypeString + '\'' +
				", cmsAccountBankString='" + cmsAccountBankString + '\'' +
				", delvagentSeq=" + delvagentSeq +
				'}';
	}
}
