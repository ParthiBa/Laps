package com.team6.LapsApp.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;
@Entity
@Table (name="leaveDetails")
public class LeaveDetail implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1997019826630132133L;

	/**
	 * 
	 */
	@EmbeddedId
	private LeaveDetailCompositeID id;
	
	@Column(name="RoleID")
	private String roleID;
    @Basic
	@Column(name="LeaveTypeID")
	private String leaveTypeID;
    
	@Column(name="ToDate")
	private Date toDate;
	
	@ManyToOne
	@JoinColumn(name = "EmployeeID")
	@MapsId("id.employeeID")
    private Employee m_emp;
	
	@ManyToOne
	@JoinColumn(name = "ManagerID")
	@MapsId("id.employeeID")
    private Manager m_manager;
	
	@Column(name="NumberOfDays")
	private Double NUmberOfDays;
	@Column(name="leaveStatus")
	private String leaveStatus;
	@Column(name="workDissemination")
	private String workDissemination;
	
	@Column(name="ContactDetails")
	private String contactDetail;
	
	public LeaveDetail() {
		this.id = new LeaveDetailCompositeID();
	}
	public LeaveDetail(String EmpID, Date date) {
        this.id = new LeaveDetailCompositeID(EmpID, date);
    }
	public String getContactDetail() {
		return contactDetail;
	}
	
	public String getEmployeeID() {
		return id.getEmployeeID();
	}
	
	public Date getFromDate() {
		return id.getFromDate();
	}
	public LeaveDetailCompositeID getId() {
		return id;
	}
	public String getLeaveStatus() {
		return leaveStatus;
	}
	public String getLeaveTypeID() {
		return leaveTypeID;
	}
	public Employee getM_emp() {
		return m_emp;
	}
	public EmployeeBase getM_empbase() {
		return m_emp;
	}
	public Manager getM_manager() {
		return m_manager;
	}
	public Double getNUmberOfDays() {
		return NUmberOfDays;
	}
	public String getRoleID() {
		return roleID;
	}
	public Date getToDate() {
		return toDate;
	}
	public String getWorkDissemination() {
		return workDissemination;
	}
	public void setContactDetail(String contactDetail) {
		this.contactDetail = contactDetail;
	}
	public void setEmployeeID(String employeeID) {
		this.id.setEmployeeID(employeeID);
	}
	public void setFromDate(Date fromDate) {
		this.id.setFromDate(fromDate);
	}
	public void setId(LeaveDetailCompositeID id) {
		this.id = id;
	}
	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	public void setLeaveTypeID(String leaveTypeID) {
		this.leaveTypeID = leaveTypeID;
	}
	public void setM_emp(Employee m_emp) {
		this.m_emp = m_emp;
	}
	public void setM_empbase(Employee m_emp) {
		this.m_emp = m_emp;
	}
	public void setM_manager(Manager m_manager) {
		this.m_manager = m_manager;
	}
	public void setNUmberOfDays(Double nUmberOfDays) {
		NUmberOfDays = nUmberOfDays;
	}
	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public void setWorkDissemination(String workDissemination) {
		this.workDissemination = workDissemination;
	}
	

}
