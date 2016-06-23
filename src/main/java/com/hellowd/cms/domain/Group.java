package com.hellowd.cms.domain;

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
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * @author SangHoon, Lee(devsh@helloworlds.co.kr)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "groups")
public class Group {

	public static final long ADMINISTRATORS = 1;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;

	@Column(name = "name")
	@NotNull
	@NotEmpty
	@Length(max = 45)
	private String name;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "group_permission", joinColumns = @JoinColumn(name = "group_seq"), inverseJoinColumns = @JoinColumn(name = "permission_seq"))
	private Set<Permission> permissionList;

	public Set<Permission> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(Set<Permission> permissionList) {
		this.permissionList = permissionList;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
