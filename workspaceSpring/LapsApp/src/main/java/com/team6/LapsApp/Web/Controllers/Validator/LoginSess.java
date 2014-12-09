package com.team6.LapsApp.Web.Controllers.Validator;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class LoginSess  implements Serializable 
{
	
	public String getRoleID() {
		return RoleID;
	}

	public void setRoleID(String roleID) {
		RoleID = roleID;
	}

	private String EmpID;
	
	private String password;
	
	private String RoleID;

	public String getEmpiD() {
		return EmpID;
	}

	public void setEmpiD(String empiD) {
		EmpID = empiD;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginSess() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginSess(String empID, String password) {
		super();
		EmpID = empID;
		this.password = password;
	}
	
	

}
