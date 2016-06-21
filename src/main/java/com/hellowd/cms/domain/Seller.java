package com.hellowd.cms.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
import java.util.Date;

/**
 * @author SangHoon, Lee(devsh@helloworlds.co.kr)
 */
@Entity
@Table(name = "seller_tree")
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;

	@Column(name = "parent_seq", nullable = false)
	private Long parentSeq;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "parent_seq", insertable = false, updatable = false)
	private Seller parent;

	@Column(name = "depth")
	private int depth;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "name", length = 30, nullable = false)
	private String name;

	@Column(name = "mobile", length = 13, nullable = false)
	private String mobile;

//    @Column(name = "administrator_seq")
//    private Long administratorSeq;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "administrator_seq", insertable = false, updatable = false)
//    private Administrator administrator;

	@Column(name = "code")
	private String code;

	@Column(name = "hidden")
	private int hidden;

	@Column(name = "regdate")
	private Date regdate;

	@Column(name = "left_seq")
	private Long leftSeq;

	@Transient
	private Seller leftChild;

	@Transient
	private Seller rightSibling;

	@Transient
	private String child;

	@Transient
	private Long fmsAccountCount;
	@Transient
	private String withdrawnYN = "N";
	@Transient
	private String withdrawnDate;
	@Transient
	private String withdrawnPrice;

	public String getWithdrawnPrice() {
		return withdrawnPrice;
	}

	public void setWithdrawnPrice(String withdrawnPrice) {
		this.withdrawnPrice = withdrawnPrice;
	}

	public String getWithdrawnDate() {
		return withdrawnDate;
	}

	public void setWithdrawnDate(String withdrawnDate) {
		this.withdrawnDate = withdrawnDate;
	}

	public String getWithdrawnYN() {
		return withdrawnYN;
	}

	public void setWithdrawnYN(String withdrawnYN) {
		this.withdrawnYN = withdrawnYN;
	}

	public void setFmsAccountCount(Long fmsAccountCount) {
		this.fmsAccountCount = fmsAccountCount;
	}

	public Long getFmsAccountCount() {
		return fmsAccountCount;
	}


	public String getChild() {
		return child;
	}

	public void setChild(String child) {
		this.child = child;
	}

	public Seller getRightSibling() {
		return rightSibling;
	}

	public void setRightSibling(Seller rightSbling) {
		this.rightSibling = rightSbling;
	}

	public Seller getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Seller leftChild) {
		this.leftChild = leftChild;
	}

//    @OneToOne(mappedBy = "seller", fetch = FetchType.EAGER)
//    @Fetch(FetchMode.SELECT)
//    private SellerStore sellerStore;


	public Long getLeftSeq() {
		return leftSeq;
	}

	public void setLeftSeq(Long leftSeq) {
		this.leftSeq = leftSeq;
	}

	public Seller getParent() {
		return parent;
	}

	public void setParent(Seller parent) {
		this.parent = parent;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getHidden() {
		return hidden;
	}

	public void setHidden(int hidden) {
		this.hidden = hidden;
	}


	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParentSeq() {
		return parentSeq;
	}

	public void setParentSeq(Long parentSeq) {
		this.parentSeq = parentSeq;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	@Override
	public String toString() {
		return "{" +
				"\"seq\":\"" + seq + '\"' +
				", \"parentSeq\":\"" + parentSeq + '\"' +
				", \"depth\":\"" + depth + '\"' +
				", \"email\":\"" + email + '\"' +
				", \"name\":\"" + name + '\"' +
				", \"mobile\":\"" + mobile + '\"' +
//                ", \"code\":\"" + code + '\"' +
				", \"child\":" + child +
				", \"fmsAccountCount\":\"" + fmsAccountCount + '\"' +
//                ", \"leftChild\":" + leftChild +
//                ", \"rightSibling\":" + rightSibling +
//                ", \"hidden\":\"" + hidden + '\"' +
				", \"regdate\":\"" + regdate + '\"' +
				'}';
	}
}
