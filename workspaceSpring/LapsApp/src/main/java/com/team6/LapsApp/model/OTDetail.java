package com.team6.LapsApp.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "OTDetails")
public class OTDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1856669704833568101L;

	@EmbeddedId
	public OTDetailsCompositeID m_itID = null;

	@Column(name = "IsFullDay")
	private Boolean isFullDay;
	@Column(name = "IsApproved")
	private Boolean isApproved;

	@ManyToOne
	@JoinColumn(name = "EmployeeID")
	@MapsId("employeeID")
	private Employee m_empot;

	public OTDetailsCompositeID getM_itID() {
		return m_itID;
	}

	public void setM_itID(OTDetailsCompositeID m_itID) {
		this.m_itID = m_itID;
	}

	public Boolean getIsFullDay() {
		return isFullDay;
	}

	public void setIsFullDay(Boolean isFullDay) {
		this.isFullDay = isFullDay;
	}

	public Boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}

	public Employee getM_empot() {
		return m_empot;
	}

	public void setM_empot(Employee m_empot) {
		this.m_empot = m_empot;
	}

	public Manager getM_manager() {
		return m_manager;
	}

	public void setM_manager(Manager m_manager) {
		this.m_manager = m_manager;
	}

	@ManyToOne
	@JoinColumn(name = "ManagerID")
	@MapsId("employeeID")
	private Manager m_manager;

	public OTDetail() {
		if(m_itID == null)
			this.m_itID = new OTDetailsCompositeID();
	}

	public OTDetail(String EmpID, Date date) {
		this.m_itID = new OTDetailsCompositeID(EmpID, date);
	}
}
