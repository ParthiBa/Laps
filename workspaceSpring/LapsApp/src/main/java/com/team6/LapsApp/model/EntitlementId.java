package com.team6.LapsApp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EntitlementId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Column
	(name="RoleID")
	private String roleId;
	@Column
	(name="LeaveTypeID")
	private String leaveTypeId;
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getLeaveTypeId() {
		return leaveTypeId;
	}
	public void setLeaveTypeId(String leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}
	public EntitlementId(String roleId, String leaveTypeId) {
		super();
		this.roleId = roleId;
		this.leaveTypeId = leaveTypeId;
	}
	public EntitlementId() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((leaveTypeId == null) ? 0 : leaveTypeId.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
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
		EntitlementId other = (EntitlementId) obj;
		if (leaveTypeId == null) {
			if (other.leaveTypeId != null)
				return false;
		} else if (!leaveTypeId.equals(other.leaveTypeId))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		return true;
	}
	
	
	

}
