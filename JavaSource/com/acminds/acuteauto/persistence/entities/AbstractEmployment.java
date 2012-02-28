package com.acminds.acuteauto.persistence.entities;

// Generated Feb 28, 2012 12:49:46 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.acminds.acuteauto.persistence.dto.*;

/**
 * Employment generated by customhbm2java
 */
@MappedSuperclass
public abstract class AbstractEmployment extends
		com.acminds.acuteauto.persistence.BaseDTO implements
		java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer employmentId;
	private UserInfo userInfo;
	private String employerName;
	private String designation;
	private String occupation;
	private int incomeMonthly;
	private Date employmentPeriod;
	private Boolean currentEmployer;
	private Date createDate;
	private List<Location> locations = new ArrayList<Location>(0);

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "EMPLOYMENT_ID", unique = true, nullable = false)
	public Integer getEmploymentId() {
		return this.employmentId;
	}

	public void setEmploymentId(Integer employmentId) {
		this.employmentId = employmentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_INFO_ID", nullable = false)
	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	@Column(name = "EMPLOYER_NAME", nullable = false, length = 60)
	public String getEmployerName() {
		return this.employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	@Column(name = "DESIGNATION", nullable = false, length = 60)
	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Column(name = "OCCUPATION", length = 60)
	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	@Column(name = "INCOME_MONTHLY", nullable = false)
	public int getIncomeMonthly() {
		return this.incomeMonthly;
	}

	public void setIncomeMonthly(int incomeMonthly) {
		this.incomeMonthly = incomeMonthly;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EMPLOYMENT_PERIOD", nullable = false, length = 10)
	public Date getEmploymentPeriod() {
		return this.employmentPeriod;
	}

	public void setEmploymentPeriod(Date employmentPeriod) {
		this.employmentPeriod = employmentPeriod;
	}

	@Column(name = "CURRENT_EMPLOYER")
	public Boolean getCurrentEmployer() {
		return this.currentEmployer;
	}

	public void setCurrentEmployer(Boolean currentEmployer) {
		this.currentEmployer = currentEmployer;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", nullable = false, length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employment")
	public List<Location> getLocations() {
		return this.locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

}
