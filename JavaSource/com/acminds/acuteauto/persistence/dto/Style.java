package com.acminds.acuteauto.persistence.dto;

// Generated Feb 29, 2012 11:25:37 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Style generated by customhbm2java
 */
import javax.faces.bean.ManagedBean;

import com.acminds.acuteauto.persistence.entities.AbstractStyle;

@ManagedBean(name = "style")
@Entity
@Table(name = "STYLE")
public class Style extends AbstractStyle {
	private static final long serialVersionUID = 1L;
	
	private Make make;
	@Transient
	public Make getMake() {
		return make;
	}
	public void setMake(Make make) {
		this.make = make;
	}
	private boolean editable;
	@Transient
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}

}
