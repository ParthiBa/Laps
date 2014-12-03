package com.team6.LapsApp.model;

import java.sql.Date;

import javax.persistence.*;
@Entity
@Table (name="leaveDetails")
public class LeaveDetail {
	@Id
	@Column(name="EmployeeID")
	private String employeeID;
	@Id
	@Column(name="RoleID")
	private String roleID;
	@Basic
	@Column(name="LeaveTypeID")
	private String leaveTypeID;
	@Column(name="FromDate")
	private Date fromDate;
	@Column(name="ToDate")
	private Date toDate;
	@Column(name="isFullDay")
	private Boolean isFullDay;
	@Column(name="leaveStatus")
	private String leaveStatus;
	@Column(name="workDissemination")
	private String workDissemination;
	@Column(name="ContactDetails")
	private String contactDetail;
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public String getRoleID() {
		return roleID;
	}
	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}
	public String getLeaveTypeID() {
		return leaveTypeID;
	}
	public void setLeaveTypeID(String leaveTypeID) {
		this.leaveTypeID = leaveTypeID;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public Boolean getIsFullDay() {
		return isFullDay;
	}
	public void setIsFullDay(Boolean isFullDay) {
		this.isFullDay = isFullDay;
	}
	public String getLeaveStatus() {
		return leaveStatus;
	}
	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	public String getWorkDissemination() {
		return workDissemination;
	}
	public void setWorkDissemination(String workDissemination) {
		this.workDissemination = workDissemination;
	}
	public String getContactDetail() {
		return contactDetail;
	}
	public void setContactDetail(String contactDetail) {
		this.contactDetail = contactDetail;
	}
	

}
