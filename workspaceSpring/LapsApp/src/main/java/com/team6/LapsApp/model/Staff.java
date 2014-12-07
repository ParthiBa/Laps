package com.team6.LapsApp.model;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class Staff extends Employee{

	@NotNull
	@Column(name="SupervisorID")
	private String supervisorID;
	
	public String getSupervisorID() {
		return supervisorID;
	}
	public void setSupervisorID(String supervisorID) {
		this.supervisorID = supervisorID;
	}
}
