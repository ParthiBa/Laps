package com.team6.LapsApp.service;

import java.util.List;

import com.team6.LapsApp.model.Employee;
import com.team6.LapsApp.model.EmployeeBase;
import com.team6.LapsApp.model.EmployeeRole;
import com.team6.LapsApp.model.Holiday;
import com.team6.LapsApp.model.LeaveDetail;
import com.team6.LapsApp.model.LeaveDetailCompositeID;
import com.team6.LapsApp.model.LeaveType;
import com.team6.LapsApp.model.Manager;
import com.team6.LapsApp.model.OTDetail;

public interface LeaveApplicationService {
	
	//Manager
	public Manager findManagerByID(String empid); 
	public List<LeaveDetail> ListPersonTookMaxLeave();
		
	//employess
	
    public void ApplyLeave(LeaveDetail ld);
    public void ApplyClaim(OTDetail ot);
    public Employee findEmployee(String id);
    public Employee updateEmployeeDetails(Employee s); 
    public List<Manager> ListOfSuperVisor();
    
    //Admin
    public void CreateEmployeeID(Employee e);
    public void UpdateEmployeeID(Employee e);
    public Employee DeleteEmployeeID(String empid);
    public void CreateLeaveType(LeaveType lt);
    public LeaveType DeleteLeaveType(String lt);
    public void CreateNewRole(EmployeeRole er);
    public void CreateHoliday(Holiday hl);
    public Holiday DeleteHoliday(String hl);
    
    
    //General
    public List<LeaveType> GetAllLeaveTypes();
    public LeaveDetail GetLeaveById(LeaveDetailCompositeID key);
    public void LeaveDetailsUpdate(LeaveDetail ld);
    public List<Employee> SearchEmpbyName(String na);
    public List<Holiday> GetAllHolidays();
    public List<Employee>FindAllEmployee();
}
