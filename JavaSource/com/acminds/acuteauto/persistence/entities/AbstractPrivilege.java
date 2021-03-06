package com.acminds.acuteauto.persistence.entities;

// Generated Mar 3, 2012 9:48:22 AM by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

import com.acminds.acuteauto.persistence.dto.*;

/**
 * Privilege generated by customhbm2java
 */
@MappedSuperclass
public abstract class AbstractPrivilege extends
		com.acminds.acuteauto.persistence.BaseDTO implements
		java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer privilegeId;
	private String privName;
	private String privCode;
	private String privDesc;
	private String tranUri;
	private List<Role> roles = new ArrayList<Role>(0);

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "PRIVILEGE_ID", unique = true, nullable = false)
	public Integer getPrivilegeId() {
		return this.privilegeId;
	}

	public void setPrivilegeId(Integer privilegeId) {
		this.privilegeId = privilegeId;
	}

	@Column(name = "PRIV_NAME", nullable = false, length = 25)
	public String getPrivName() {
		return this.privName;
	}

	public void setPrivName(String privName) {
		this.privName = privName;
	}

	@Column(name = "PRIV_CODE", nullable = false, length = 20)
	public String getPrivCode() {
		return this.privCode;
	}

	public void setPrivCode(String privCode) {
		this.privCode = privCode;
	}

	@Column(name = "PRIV_DESC", length = 100)
	public String getPrivDesc() {
		return this.privDesc;
	}

	public void setPrivDesc(String privDesc) {
		this.privDesc = privDesc;
	}

	@Column(name = "TRAN_URI", length = 100)
	public String getTranUri() {
		return this.tranUri;
	}

	public void setTranUri(String tranUri) {
		this.tranUri = tranUri;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "privileges")
	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
