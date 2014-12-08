package com.team6.LapsApp.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LeaveDetailCompositeID implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 289230404241252787L;

	@Column(name="EmployeeID")
	private String employeeID;
	
	@Column(name="FromDate")
	private Date fromDate;

	public LeaveDetailCompositeID() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LeaveDetailCompositeID other = (LeaveDetailCompositeID) obj;
		if (employeeID == null) {
			if (other.employeeID != null)
				return false;
		} else if (!employeeID.equals(other.employeeID))
			return false;
		if (fromDate == null) {
			if (other.fromDate != null)
				return false;
		} else if (!fromDate.equals(other.fromDate))
			return false;
		return true;
	}

	public LeaveDetailCompositeID(String employeeID, Date fromDate) {
		super();
		this.employeeID = employeeID;
		this.fromDate = fromDate;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public Date getFromDate() {
		return fromDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((employeeID == null) ? 0 : employeeID.hashCode());
		result = prime * result
				+ ((fromDate == null) ? 0 : fromDate.hashCode());
		return result;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
}
