package com.team6.LapsApp.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class OTDetailsCompositeID implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3746197530570441089L;

	/**
	 * 
	 */
	@Column(name="EmployeeID")
	public String employeeID;
	
	@Column(name="OTWorkedDate")
	public Date m_otWorkedDate;

	public OTDetailsCompositeID() {
	}
	
	public OTDetailsCompositeID(String employeeID, Date m_otWorkedDate) {
		super();
		this.employeeID = employeeID;
		this.m_otWorkedDate = m_otWorkedDate;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public Date getM_otWorkedDate() {
		return m_otWorkedDate;
	}

	public void setM_otWorkedDate(Date m_otWorkedDate) {
		this.m_otWorkedDate = m_otWorkedDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((employeeID == null) ? 0 : employeeID.hashCode());
		result = prime * result
				+ ((m_otWorkedDate == null) ? 0 : m_otWorkedDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OTDetailsCompositeID other = (OTDetailsCompositeID) obj;
		if (employeeID == null) {
			if (other.employeeID != null)
				return false;
		} else if (!employeeID.equals(other.employeeID))
			return false;
		if (m_otWorkedDate == null) {
			if (other.m_otWorkedDate != null)
				return false;
		} else if (!m_otWorkedDate.equals(other.m_otWorkedDate))
			return false;
		return true;
	}
}
