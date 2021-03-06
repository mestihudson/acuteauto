package com.acminds.acuteauto.persistence.entities;

// Generated Mar 3, 2012 9:48:22 AM by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.acminds.acuteauto.persistence.dto.*;

/**
 * Feature generated by customhbm2java
 */
@MappedSuperclass
public abstract class AbstractFeature extends
		com.acminds.acuteauto.persistence.BaseDTO implements
		java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer featureId;
	private Make make;
	private FeatureGroup featureGroup;
	private String featureValue;
	private boolean addDefault;
	private Integer yearStart;
	private Integer yearEnd;
	private List<Vehicle> vehicles = new ArrayList<Vehicle>(0);
	private List<Style> styles = new ArrayList<Style>(0);

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "FEATURE_ID", unique = true, nullable = false)
	public Integer getFeatureId() {
		return this.featureId;
	}

	public void setFeatureId(Integer featureId) {
		this.featureId = featureId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MAKE_ID")
	public Make getMake() {
		return this.make;
	}

	public void setMake(Make make) {
		this.make = make;
	}
	
	@Column(name = "ADD_DEFAULT")
	public boolean isAddDefault() {
		return this.addDefault;
	}

	public void setAddDefault(Boolean addDefault) {
		this.addDefault = addDefault;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FEATURE_GROUP_ID", nullable = false)
	public FeatureGroup getFeatureGroup() {
		return this.featureGroup;
	}

	public void setFeatureGroup(FeatureGroup featureGroup) {
		this.featureGroup = featureGroup;
	}

	@Column(name = "FEATURE_VALUE", length = 100)
	public String getFeatureValue() {
		return this.featureValue;
	}

	public void setFeatureValue(String featureValue) {
		this.featureValue = featureValue;
	}

	@Column(name = "YEAR_START")
	public Integer getYearStart() {
		return this.yearStart;
	}

	public void setYearStart(Integer yearStart) {
		this.yearStart = yearStart;
	}

	@Column(name = "YEAR_END")
	public Integer getYearEnd() {
		return this.yearEnd;
	}

	public void setYearEnd(Integer yearEnd) {
		this.yearEnd = yearEnd;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "features")
	public List<Vehicle> getVehicles() {
		return this.vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "features")
	public List<Style> getStyles() {
		return this.styles;
	}

	public void setStyles(List<Style> styles) {
		this.styles = styles;
	}

}
