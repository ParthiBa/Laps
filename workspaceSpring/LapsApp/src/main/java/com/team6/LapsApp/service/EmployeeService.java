package com.team6.LapsApp.service;

import java.util.List;

import com.team6.LapsApp.model.Employee;
import com.team6.LapsApp.model.LeaveDetail;



public interface EmployeeService {
	
	public Employee create(Employee s);
	public Employee delete(String id);
//	throws StudentNotFound;
	public List<Employee> findAll();
	public Employee update(Employee s); 
	//throws StudentNotFound;
	public Employee findById(String id);
	public List<Employee> ListOfSuperVisor();
	public List<Employee> SearchEmpbyName(String na);
}
