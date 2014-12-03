package team6.LapsApp.model;

import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="employees")
public class Employee {
	@Id
	@Column(name="EmployeeID")
	private String employeeID;
	@Basic
	@NotNull
	@Column(name="Employeename")
	private String employeename;
	@Temporal(TemporalType.DATE)
	@Past
	@Column(name="DOB")
	private Date dob;
	@Column(name="RoleID")
	private String roleID;
	@NotNull
	@Column(name="Password")
	private String password;
	@NotNull
	@Column(name="SupervisorID")
	private String supervisorID;
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getRoleID() {
		return roleID;
	}
	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSupervisorID() {
		return supervisorID;
	}
	public void setSupervisorID(String supervisorID) {
		this.supervisorID = supervisorID;
	}
	
	

}
