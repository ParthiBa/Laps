package com.team6.LapsApp.model;

import javax.persistence.*;

@Entity
@Table(name="TypeOfLeave")
public class TypeOfLeave {
	@Id
	@Column(name="RoleID")
	private String roleID;
	@Basic
	@Column(name="LeaveTypeID")
	private String leaveTypeID;
	@Column(name="NumofDays")
	private int numOfDays;
	@Column(name="ApprovelRoleid")
	private String approvelRoleID;
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
	public int getNumOfDays() {
		return numOfDays;
	}
	public void setNumOfDays(int numOfDays) {
		this.numOfDays = numOfDays;
	}
	public String getApprovelRoleID() {
		return approvelRoleID;
	}
	public void setApprovelRoleID(String approvelRoleID) {
		this.approvelRoleID = approvelRoleID;
	}
	

}
