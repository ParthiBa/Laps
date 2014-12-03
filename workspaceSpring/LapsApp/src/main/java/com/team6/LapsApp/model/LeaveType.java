package com.team6.LapsApp.model;

import javax.persistence.*;

@Entity
@Table(name="LeaveType")
public class LeaveType {
	@Id
	@Column(name="LeaveTypeID")
    private String leaveTypeID;
	@Basic
	@Column(name="LeaveTypeName")
    private String leaveTypeName;
	public String getLeaveTypeID() {
		return leaveTypeID;
	}
	public void setLeaveTypeID(String leaveTypeID) {
		this.leaveTypeID = leaveTypeID;
	}
	public String getLeaveTypeName() {
		return leaveTypeName;
	}
	public void setLeaveTypeName(String leaveTypeName) {
		this.leaveTypeName = leaveTypeName;
	}
    
}
