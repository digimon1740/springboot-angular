
package com.hellowd.cms.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

	public String getFmsAccountCount() {
		return fmsAccountCount;
	}

	public void setFmsAccountCount(String fmsAccountCount) {
		this.fmsAccountCount = fmsAccountCount;
	}

	public String getWithdrawnYN() {
		return withdrawnYN;
	}

	public void setWithdrawnYN(String withdrawnYN) {
		this.withdrawnYN = withdrawnYN;
	}

	public String getWithdrawDay() {
		return withdrawDay;
	}

	public void setWithdrawDay(String withdrawDay) {
		this.withdrawDay = withdrawDay;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public Long getOwnerSeq() {
		return ownerSeq;
	}

	public void setOwnerSeq(Long ownerSeq) {
		this.ownerSeq = ownerSeq;
	}

	public StoreOwner getOwner() {
		return owner;
	}

	public void setOwner(StoreOwner owner) {
		this.owner = owner;
	}

	public Long getMobileServiceSeq() {
		return mobileServiceSeq;
	}

	public void setMobileServiceSeq(Long mobileServiceSeq) {
		this.mobileServiceSeq = mobileServiceSeq;
	}

	public int getSupportType() {
		return supportType;
	}

	public void setSupportType(int supportType) {
		this.supportType = supportType;
	}

	public int getFree() {
		return free;
	}

	public void setFree(int free) {
		this.free = free;
	}

	public int getVirtual() {
		return virtual;
	}

	public void setVirtual(int virtual) {
		this.virtual = virtual;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUseBizapp() {
		return useBizapp;
	}

	public void setUseBizapp(int useBizapp) {
		this.useBizapp = useBizapp;
	}

	public int getUseTTS() {
		return useTTS;
	}

	public void setUseTTS(int useTTS) {
		this.useTTS = useTTS;
	}

	public int getNotifyTtsOnly() {
		return notifyTtsOnly;
	}

	public void setNotifyTtsOnly(int notifyTtsOnly) {
		this.notifyTtsOnly = notifyTtsOnly;
	}

	public String getTelnum() {
		return telnum;
	}

	public void setTelnum(String telnum) {
		this.telnum = telnum;
	}

	public String getVtelnum() {
		return vtelnum;
	}

	public void setVtelnum(String vtelnum) {
		this.vtelnum = vtelnum;
	}

	public String getCellnum() {
		return cellnum;
	}

	public void setCellnum(String cellnum) {
		this.cellnum = cellnum;
	}

	public String getBizappAssistNum() {
		return bizappAssistNum;
	}

	public void setBizappAssistNum(String bizappAssistNum) {
		this.bizappAssistNum = bizappAssistNum;
	}

	public String getTtsnum() {
		return ttsnum;
	}

	public void setTtsnum(String ttsnum) {
		this.ttsnum = ttsnum;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCidWatch() {
		return cidWatch;
	}

	public void setCidWatch(String cidWatch) {
		this.cidWatch = cidWatch;
	}

	public String getPusHostPort() {
		return pusHostPort;
	}

	public void setPusHostPort(String pusHostPort) {
		this.pusHostPort = pusHostPort;
	}

	public int getHidden() {
		return hidden;
	}

	public void setHidden(int hidden) {
		this.hidden = hidden;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public int getRun24() {
		return run24;
	}

	public void setRun24(int run24) {
		this.run24 = run24;
	}

	public int getOpenTime() {
		return openTime;
	}

	public void setOpenTime(int openTime) {
		this.openTime = openTime;
	}

	public int getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(int closeTime) {
		this.closeTime = closeTime;
	}

	public int getNoclose() {
		return noclose;
	}

	public void setNoclose(int noclose) {
		this.noclose = noclose;
	}

	public int getOffweek() {
		return offweek;
	}

	public void setOffweek(int offweek) {
		this.offweek = offweek;
	}

	public int getOffday() {
		return offday;
	}

	public void setOffday(int offday) {
		this.offday = offday;
	}

	public Date getTmpOffdayStart() {
		return tmpOffdayStart;
	}

	public void setTmpOffdayStart(Date tmpOffdayStart) {
		this.tmpOffdayStart = tmpOffdayStart;
	}

	public Date getTmpOffdayEnd() {
		return tmpOffdayEnd;
	}

	public void setTmpOffdayEnd(Date tmpOffdayEnd) {
		this.tmpOffdayEnd = tmpOffdayEnd;
	}

	public String getDelvable() {
		return delvable;
	}

	public void setDelvable(String delvable) {
		this.delvable = delvable;
	}

	public String getDelvableReplace() {
		return delvableReplace;
	}

	public void setDelvableReplace(String delvableReplace) {
		this.delvableReplace = delvableReplace;
	}

	public int getDelvMinPrice() {
		return delvMinPrice;
	}

	public void setDelvMinPrice(int delvMinPrice) {
		this.delvMinPrice = delvMinPrice;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getGugun() {
		return gugun;
	}

	public void setGugun(String gugun) {
		this.gugun = gugun;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getBunji() {
		return bunji;
	}

	public void setBunji(String bunji) {
		this.bunji = bunji;
	}

	public String getRi() {
		return ri;
	}

	public void setRi(String ri) {
		this.ri = ri;
	}

	public String getAddrLegacy() {
		return addrLegacy;
	}

	public void setAddrLegacy(String addrLegacy) {
		this.addrLegacy = addrLegacy;
	}

	public String getAddrRoad() {
		return addrRoad;
	}

	public void setAddrRoad(String addrRoad) {
		this.addrRoad = addrRoad;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getZonecode() {
		return zonecode;
	}

	public void setZonecode(String zonecode) {
		this.zonecode = zonecode;
	}

	public String getEtcaddr() {
		return etcaddr;
	}

	public void setEtcaddr(String etcaddr) {
		this.etcaddr = etcaddr;
	}

	public String getGpslat() {
		return gpslat;
	}

	public void setGpslat(String gpslat) {
		this.gpslat = gpslat;
	}

	public String getGpslng() {
		return gpslng;
	}

	public void setGpslng(String gpslng) {
		this.gpslng = gpslng;
	}

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankOwnerName() {
		return bankOwnerName;
	}

	public void setBankOwnerName(String bankOwnerName) {
		this.bankOwnerName = bankOwnerName;
	}

	public Long getFranchiseTypeSeq() {
		return franchiseTypeSeq;
	}

	public void setFranchiseTypeSeq(Long franchiseTypeSeq) {
		this.franchiseTypeSeq = franchiseTypeSeq;
	}

	public int getCommissionType() {
		return commissionType;
	}

	public void setCommissionType(int commissionType) {
		this.commissionType = commissionType;
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}

	public int getChargePayCommission() {
		return chargePayCommission;
	}

	public void setChargePayCommission(int chargePayCommission) {
		this.chargePayCommission = chargePayCommission;
	}

	public Double getPaynowCommission() {
		return paynowCommission;
	}

	public void setPaynowCommission(Double paynowCommission) {
		this.paynowCommission = paynowCommission;
	}

	public Double getFastPaynowCommission() {
		return fastPaynowCommission;
	}

	public void setFastPaynowCommission(Double fastPaynowCommission) {
		this.fastPaynowCommission = fastPaynowCommission;
	}

	public int getFixedFee() {
		return fixedFee;
	}

	public void setFixedFee(int fixedFee) {
		this.fixedFee = fixedFee;
	}

	public double getSalerate() {
		return salerate;
	}

	public void setSalerate(double salerate) {
		this.salerate = salerate;
	}

	public int getBookDiscount() {
		return bookDiscount;
	}

	public void setBookDiscount(int bookDiscount) {
		this.bookDiscount = bookDiscount;
	}

	public long getBookDiscountBalance() {
		return bookDiscountBalance;
	}

	public void setBookDiscountBalance(long bookDiscountBalance) {
		this.bookDiscountBalance = bookDiscountBalance;
	}

	public double getBookDiscountRate() {
		return bookDiscountRate;
	}

	public void setBookDiscountRate(double bookDiscountRate) {
		this.bookDiscountRate = bookDiscountRate;
	}

	public Date getBookDiscountStartDate() {
		return bookDiscountStartDate;
	}

	public void setBookDiscountStartDate(Date bookDiscountStartDate) {
		this.bookDiscountStartDate = bookDiscountStartDate;
	}

	public Date getBookDiscountEndDate() {
		return bookDiscountEndDate;
	}

	public void setBookDiscountEndDate(Date bookDiscountEndDate) {
		this.bookDiscountEndDate = bookDiscountEndDate;
	}

	public Long getSellerSeq() {
		return sellerSeq;
	}

	public void setSellerSeq(Long sellerSeq) {
		this.sellerSeq = sellerSeq;
	}

	public long getCallCount() {
		return callCount;
	}

	public void setCallCount(long callCount) {
		this.callCount = callCount;
	}

	public long getOrderCompleteCount() {
		return orderCompleteCount;
	}

	public void setOrderCompleteCount(long orderCompleteCount) {
		this.orderCompleteCount = orderCompleteCount;
	}

	public long getEstimateCount() {
		return estimateCount;
	}

	public void setEstimateCount(long estimateCount) {
		this.estimateCount = estimateCount;
	}

	public long getEstimateReplyCount() {
		return estimateReplyCount;
	}

	public void setEstimateReplyCount(long estimateReplyCount) {
		this.estimateReplyCount = estimateReplyCount;
	}

	public int getEstimateSum() {
		return estimateSum;
	}

	public void setEstimateSum(int estimateSum) {
		this.estimateSum = estimateSum;
	}

	public String getLogoImage() {
		return logoImage;
	}

	public void setLogoImage(String logoImage) {
		this.logoImage = logoImage;
	}

	public String getPaperImage() {
		return paperImage;
	}

	public void setPaperImage(String paperImage) {
		this.paperImage = paperImage;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public long getSendSmsCount() {
		return sendSmsCount;
	}

	public void setSendSmsCount(long sendSmsCount) {
		this.sendSmsCount = sendSmsCount;
	}

	public Date getFreeServiceExpiredDate() {
		return freeServiceExpiredDate;
	}

	public void setFreeServiceExpiredDate(Date freeServiceExpiredDate) {
		this.freeServiceExpiredDate = freeServiceExpiredDate;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getMobilePageName() {
		return mobilePageName;
	}

	public void setMobilePageName(String mobilePageName) {
		this.mobilePageName = mobilePageName;
	}

	public Date getContractTermFrom() {
		return contractTermFrom;
	}

	public void setContractTermFrom(Date contractTermFrom) {
		this.contractTermFrom = contractTermFrom;
	}

	public Date getContractTermTo() {
		return contractTermTo;
	}

	public void setContractTermTo(Date contractTermTo) {
		this.contractTermTo = contractTermTo;
	}

	public int getActivateStatus() {
		return activateStatus;
	}

	public void setActivateStatus(int activateStatus) {
		this.activateStatus = activateStatus;
	}

	public int getMobileStatus() {
		return mobileStatus;
	}

	public void setMobileStatus(int mobileStatus) {
		this.mobileStatus = mobileStatus;
	}

	public int getUplusPromo() {
		return uplusPromo;
	}

	public void setUplusPromo(int uplusPromo) {
		this.uplusPromo = uplusPromo;
	}

	public int getOwnerTakeCommission() {
		return ownerTakeCommission;
	}

	public void setOwnerTakeCommission(int ownerTakeCommission) {
		this.ownerTakeCommission = ownerTakeCommission;
	}

	public int getTestStore() {
		return testStore;
	}

	public void setTestStore(int testStore) {
		this.testStore = testStore;
	}

	public Integer getUseCMS() {
		return useCMS;
	}

	public void setUseCMS(Integer useCMS) {
		this.useCMS = useCMS;
	}

	public Integer getCmsType() {
		return cmsType;
	}

	public void setCmsType(Integer cmsType) {
		this.cmsType = cmsType;
	}

	public Date getCmsTransferDate() {
		return cmsTransferDate;
	}

	public void setCmsTransferDate(Date cmsTransferDate) {
		this.cmsTransferDate = cmsTransferDate;
	}

	public String getCmsAccount() {
		return cmsAccount;
	}

	public void setCmsAccount(String cmsAccount) {
		this.cmsAccount = cmsAccount;
	}

	public String getCmsAccountValue() {
		return cmsAccountValue;
	}

	public void setCmsAccountValue(String cmsAccountValue) {
		this.cmsAccountValue = cmsAccountValue;
	}

	public String getCmsAccountBank() {
		return cmsAccountBank;
	}

	public void setCmsAccountBank(String cmsAccountBank) {
		this.cmsAccountBank = cmsAccountBank;
	}

	public String getCmsAccountOwnerName() {
		return cmsAccountOwnerName;
	}

	public void setCmsAccountOwnerName(String cmsAccountOwnerName) {
		this.cmsAccountOwnerName = cmsAccountOwnerName;
	}

	public String getCmsAccountVerifyInfo() {
		return cmsAccountVerifyInfo;
	}

	public void setCmsAccountVerifyInfo(String cmsAccountVerifyInfo) {
		this.cmsAccountVerifyInfo = cmsAccountVerifyInfo;
	}

	public String getCmsWithdrawDay() {
		return cmsWithdrawDay;
	}

	public void setCmsWithdrawDay(String cmsWithdrawDay) {
		this.cmsWithdrawDay = cmsWithdrawDay;
	}

	public int getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}

	public long getVtelCallCount() {
		return vtelCallCount;
	}

	public void setVtelCallCount(long vtelCallCount) {
		this.vtelCallCount = vtelCallCount;
	}

	public int getRegisterWaiting() {
		return registerWaiting;
	}

	public void setRegisterWaiting(int registerWaiting) {
		this.registerWaiting = registerWaiting;
	}

	public String getRegisterMemo() {
		return registerMemo;
	}

	public void setRegisterMemo(String registerMemo) {
		this.registerMemo = registerMemo;
	}

	public String getCmsTypeString() {
		return cmsTypeString;
	}

	public void setCmsTypeString(String cmsTypeString) {
		this.cmsTypeString = cmsTypeString;
	}

	public String getCmsAccountBankString() {
		return cmsAccountBankString;
	}

	public void setCmsAccountBankString(String cmsAccountBankString) {
		this.cmsAccountBankString = cmsAccountBankString;
	}

	public Long getDelvagentSeq() {
		return delvagentSeq;
	}

	public void setDelvagentSeq(Long delvagentSeq) {
		this.delvagentSeq = delvagentSeq;
	}

	public int getHideReason() {
		return hideReason;
	}

	public void setHideReason(int hideReason) {
		this.hideReason = hideReason;
	}

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
