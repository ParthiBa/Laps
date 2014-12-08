package com.team6.LapsApp.service;

import java.util.List;

import com.team6.LapsApp.model.Employee;
import com.team6.LapsApp.model.EmployeeBase;
import com.team6.LapsApp.model.LeaveDetail;
import com.team6.LapsApp.model.Manager;
import com.team6.LapsApp.model.OTDetail;

public interface LeaveApplicationService {
	
	//Manager
	public Manager findManagerByID(String empid); 
	/*public List<LeaveDetail> FindLeaveApplicationForApproval(String empid);
	public List<OTDetail>FindClaimApplicationForApproval(String empid);*/
	public List<LeaveDetail> ListPersonTookMaxLeave();
	
	//employess
	
    public void ApplyLeave(LeaveDetail ld);
    public void ApplyClaim(OTDetail ot);
    public Employee findById(String id);
    
    //Admin
    public void CreateEmployeeID();
    public void UpdateEmployeeID();
    public void DeleteEmployeeID();
    public void CreateLeaveType();
    public void CreateNewRole();
}
