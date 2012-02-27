package com.acminds.acuteauto.persistence.entities;

// Generated Feb 26, 2012 11:32:13 PM by Hibernate Tools 3.4.0.CR1

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

import com.acminds.acuteauto.persistence.dto.*;

/**
 * FeatureGroup generated by customhbm2java
 */
@MappedSuperclass
public abstract class AbstractFeatureGroup extends
		com.acminds.acuteauto.persistence.BaseDTO implements
		java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer featureGroupId;
	private FeatureGroup featureGroup;
	private String name;
	private Integer displayAs;
	private String description;
	private List<FeatureGroup> featureGroups = new ArrayList<FeatureGroup>(0);
	private List<Feature> features = new ArrayList<Feature>(0);

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "FEATURE_GROUP_ID", unique = true, nullable = false)
	public Integer getFeatureGroupId() {
		return this.featureGroupId;
	}

	public void setFeatureGroupId(Integer featureGroupId) {
		this.featureGroupId = featureGroupId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID")
	public FeatureGroup getFeatureGroup() {
		return this.featureGroup;
	}

	public void setFeatureGroup(FeatureGroup featureGroup) {
		this.featureGroup = featureGroup;
	}

	@Column(name = "NAME", nullable = false, length = 60)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DISPLAY_AS")
	public Integer getDisplayAs() {
		return this.displayAs;
	}

	public void setDisplayAs(Integer displayAs) {
		this.displayAs = displayAs;
	}

	@Column(name = "DESCRIPTION", length = 100)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "featureGroup")
	public List<FeatureGroup> getFeatureGroups() {
		return this.featureGroups;
	}

	public void setFeatureGroups(List<FeatureGroup> featureGroups) {
		this.featureGroups = featureGroups;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "featureGroup")
	public List<Feature> getFeatures() {
		return this.features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

}
