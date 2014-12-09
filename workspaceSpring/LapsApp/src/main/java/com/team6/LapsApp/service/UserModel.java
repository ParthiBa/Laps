package com.team6.LapsApp.service;

import org.springframework.stereotype.Component;


@Component
public class UserModel 
{
	private String EmpID;
	
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmpID() {
		return EmpID;
	}

	public void setEmpID(String empID) {
		EmpID = empID;
	}

	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserModel(String empID, String password) {
		super();
		EmpID = empID;
		this.password = password;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}



}
