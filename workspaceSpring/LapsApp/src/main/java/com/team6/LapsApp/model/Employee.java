package com.team6.LapsApp.model;

import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name="employees")
public class Employee extends EmployeeBase{
	@Column(name="supervisorid")
	private String SuperVisorID;

	public String getSuperVisorID() {
		return SuperVisorID;
	}

	public void setSuperVisorID(String superVisorID) {
		SuperVisorID = superVisorID;
	}
}
