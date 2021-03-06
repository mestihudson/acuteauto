package com.acminds.acuteauto.persistence.entities;

// Generated May 13, 2012 8:21:43 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.acminds.acuteauto.persistence.dto.*;

/**
 * TradeinInfo generated by customhbm2java
 */
@MappedSuperclass
public abstract class AbstractTradeinInfo extends
		com.acminds.acuteauto.persistence.BaseDTO implements
		java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer tradeinInfoId;
	private LoanApplication loanApplication;
	private Style style;
	private Make make;
	private Model model;
	private String color;
	private Integer mileage;
	private Integer year;
	private String vin;
	private BigDecimal payoffAmount;
	private Date payoffThruDate;
	private String lienHolderAdd1;
	private String lienHolderAdd2;
	private String lienHolderCity;
	private String lienHolderState;
	private String lienHolderZip;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "TRADEIN_INFO_ID", unique = true, nullable = false)
	public Integer getTradeinInfoId() {
		return this.tradeinInfoId;
	}

	public void setTradeinInfoId(Integer tradeinInfoId) {
		this.tradeinInfoId = tradeinInfoId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LOAN_APPLICATION_ID", nullable = false)
	public LoanApplication getLoanApplication() {
		return this.loanApplication;
	}

	public void setLoanApplication(LoanApplication loanApplication) {
		this.loanApplication = loanApplication;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STYLE_ID", nullable = false)
	public Style getStyle() {
		return this.style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MAKE_ID", nullable = false)
	public Make getMake() {
		return this.make;
	}

	public void setMake(Make make) {
		this.make = make;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MODEL_ID", nullable = false)
	public Model getModel() {
		return this.model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	@Column(name = "COLOR", length = 20)
	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Column(name = "MILEAGE")
	public Integer getMileage() {
		return this.mileage;
	}

	@Column(name = "YEAR")
	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}

	@Column(name = "VIN", length = 60)
	public String getVin() {
		return this.vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	@Column(name = "PAYOFF_AMOUNT", precision = 8)
	public BigDecimal getPayoffAmount() {
		return this.payoffAmount;
	}

	public void setPayoffAmount(BigDecimal payoffAmount) {
		this.payoffAmount = payoffAmount;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PAYOFF_THRU_DATE", length = 10)
	public Date getPayoffThruDate() {
		return this.payoffThruDate;
	}

	public void setPayoffThruDate(Date payoffThruDate) {
		this.payoffThruDate = payoffThruDate;
	}

	@Column(name = "LIEN_HOLDER_ADD1", length = 100)
	public String getLienHolderAdd1() {
		return this.lienHolderAdd1;
	}

	public void setLienHolderAdd1(String lienHolderAdd1) {
		this.lienHolderAdd1 = lienHolderAdd1;
	}

	@Column(name = "LIEN_HOLDER_ADD2", length = 100)
	public String getLienHolderAdd2() {
		return this.lienHolderAdd2;
	}

	public void setLienHolderAdd2(String lienHolderAdd2) {
		this.lienHolderAdd2 = lienHolderAdd2;
	}

	@Column(name = "LIEN_HOLDER_CITY", length = 20)
	public String getLienHolderCity() {
		return this.lienHolderCity;
	}

	public void setLienHolderCity(String lienHolderCity) {
		this.lienHolderCity = lienHolderCity;
	}

	@Column(name = "LIEN_HOLDER_STATE", length = 2)
	public String getLienHolderState() {
		return this.lienHolderState;
	}

	public void setLienHolderState(String lienHolderState) {
		this.lienHolderState = lienHolderState;
	}

	@Column(name = "LIEN_HOLDER_ZIP", length = 5)
	public String getLienHolderZip() {
		return this.lienHolderZip;
	}

	public void setLienHolderZip(String lienHolderZip) {
		this.lienHolderZip = lienHolderZip;
	}

}
