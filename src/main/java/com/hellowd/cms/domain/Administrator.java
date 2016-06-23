package com.hellowd.cms.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

/**
 * @author SangHoon, Lee(devsh@helloworlds.co.kr)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "administrator")
public class Administrator {

	public static final int ACTIVATE_NO = 0;
	public static final int ACTIVATE_OK = 1;

	public static final int NOTIFY_NO = 0;
	public static final int NOTIFY_OK = 1;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;

	@Column(name = "email")
	@NotNull
	@NotEmpty
	@Length(max = 60)
	private String email;

	@Column(name = "name")
	@NotNull
	@NotEmpty
	@Length(max = 30)
	private String name;

	@Column(name = "passwd")
	@NotNull
	@NotEmpty
	@Length(max = 40)
	@JsonIgnore
	private String passwd;

	@Column(name = "mobile")
	@NotNull
	@NotEmpty
	@Length(max = 13)
	private String mobile;

	@Column(name = "receipt_email")
	private Integer receiptEmail = 0;

	@Column(name = "error_email")
	private Integer errorEmail;

	@Column(name = "activate")
	private Integer activate = 1;

	@Column(name = "login_count")
	private Integer loginCount;

	@Column(name = "last_login")
	private Date lastLogin;

	@Column(name = "regdate")
	private Date regdate;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "administrator_group", joinColumns = @JoinColumn(name = "account_seq"), inverseJoinColumns = @JoinColumn(name = "group_seq"))
	private Set<Group> groupList;

	@Transient
	private Seller seller;

	@Transient
	private long groupSeq;

	public long getGroupSeq() {
		return groupSeq;
	}

	public void setGroupSeq(long groupSeq) {
		this.groupSeq = groupSeq;
	}

	public Set<Group> getGroupList() {
		return groupList;
	}

	public void setGroupList(Set<Group> groupList) {
		this.groupList = groupList;
	}

	public Group getGroup() {
		Set<Group> groups = getGroupList();
		if (groups != null && groups.size() > 0) {
			return groups.iterator().next();
		}

		return null;
	}

	public Permission getPermission() {
		Group groups = getGroup();

		if (groups != null) {
			Set<Permission> permissions = groups.getPermissionList();

			if (permissions != null && permissions.size() > 0) {
				return permissions.iterator().next();
			}
		}

		return null;
	}

	public boolean isAdmin() {
		return (getPermission().getName().equals("ROLE_ADMIN"));
	}

	public boolean isSeller() {
		return (getPermission().getName().equals("ROLE_SELLER"));
	}

	public boolean isSupervisor() {
		return (getPermission().getName().equals("ROLE_SUPERVISOR"));
	}

//    public List<Long> getAllChildSellerSeq() {
//        if (isSeller() && seller != null) {
//            List<Seller> childs = seller.getAllChildList();
//
//            if (childs.size() > 0) {
//                List<Long> childSeqs = new ArrayList<Long>(childs.size() + 1);
//                childSeqs.add(seller.getSeq());
//
//                for (Seller child : childs) {
//                    childSeqs.add(child.getSeq());
//                }
//
//                return childSeqs;
//            } else {
//                List<Long> childSeqs = new ArrayList<Long>(1);
//                childSeqs.add(seller.getSeq());
//
//                return childSeqs;
//            }
//        }
//
//        return null;
//    }

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getReceiptEmail() {
		return receiptEmail;
	}

	public void setReceiptEmail(Integer receiptEmail) {
		this.receiptEmail = receiptEmail;
	}

	public Integer getErrorEmail() {
		return errorEmail;
	}

	public void setErrorEmail(Integer errorEmail) {
		this.errorEmail = errorEmail;
	}

	public Integer getActivate() {
		return activate;
	}

	public void setActivate(Integer activate) {
		this.activate = activate;
	}

	public Integer getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

}
