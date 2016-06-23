package com.hellowd.cms.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
