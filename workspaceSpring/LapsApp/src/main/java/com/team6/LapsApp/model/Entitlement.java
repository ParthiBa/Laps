package com.team6.LapsApp.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "typeofleave")
public class Entitlement {
	
	@EmbeddedId
	private EntitlementId id;
	public void setId(EntitlementId id) {
		this.id = id;
	}
	
	public EntitlementId getId()
	{
		return id;
	}

	@Column(name="NumofDays")
	private int numOfDays;
	
	@Column(name="ApprovelRoleid")
	private String approvelRoleId;

	
	public String getRoleId() {
		return id.getRoleId();
	}
	public void setRoleId(String roleId) {
		id.setRoleId(roleId);
	}

	public String getLeaveTypeId() {
		return id.getLeaveTypeId();
	}

	public void setLeaveTypeId(String leaveTypeId) {
		id.setLeaveTypeId(leaveTypeId);
	}
	public Entitlement(String roleId, String leaveTypeId) {
		super();
		this.id =new EntitlementId(roleId,leaveTypeId);
		
	}
	public Entitlement() {
		super();
		this.id = new EntitlementId();
	
	}

	public int getNumOfDays() {
		return numOfDays;
	}

	public void setNumOfDays(int numOfDays) {
		this.numOfDays = numOfDays;
	}
	
	public String getApprovelRoleId() {
		return approvelRoleId;
	}

	public void setApprovelRoleId(String approvelRoleId) {
		this.approvelRoleId = approvelRoleId;
	}


}
