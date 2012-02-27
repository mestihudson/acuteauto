package com.acminds.acuteauto.persistence.entities;

// Generated Feb 26, 2012 11:32:13 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.acminds.acuteauto.persistence.dto.*;

/**
 * Location generated by customhbm2java
 */
@MappedSuperclass
public abstract class AbstractLocation extends
		com.acminds.acuteauto.persistence.BaseDTO implements
		java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer locationId;
	private Client client;
	private UserInfo userInfo;
	private Integer locationType;
	private String locationDesc;
	private String address1;
	private String address2;
	private String zip;
	private String city;
	private String state;
	private String homePhone;
	private String cellPhone;
	private String busNumber;
	private String email;
	private String country;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "LOCATION_ID", unique = true, nullable = false)
	public Integer getLocationId() {
		return this.locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CLIENT_ID")
	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_INFO_ID")
	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	@Column(name = "LOCATION_TYPE")
	public Integer getLocationType() {
		return this.locationType;
	}

	public void setLocationType(Integer locationType) {
		this.locationType = locationType;
	}

	@Column(name = "LOCATION_DESC", length = 100)
	public String getLocationDesc() {
		return this.locationDesc;
	}

	public void setLocationDesc(String locationDesc) {
		this.locationDesc = locationDesc;
	}

	@Column(name = "ADDRESS1", nullable = false, length = 100)
	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@Column(name = "ADDRESS2", length = 100)
	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@Column(name = "ZIP", nullable = false, length = 5)
	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Column(name = "CITY", nullable = false, length = 20)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "STATE", nullable = false, length = 2)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "HOME_PHONE", length = 10)
	public String getHomePhone() {
		return this.homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	@Column(name = "CELL_PHONE", length = 10)
	public String getCellPhone() {
		return this.cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	@Column(name = "BUS_NUMBER", length = 10)
	public String getBusNumber() {
		return this.busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	@Column(name = "EMAIL", nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "COUNTRY", nullable = false, length = 20)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
