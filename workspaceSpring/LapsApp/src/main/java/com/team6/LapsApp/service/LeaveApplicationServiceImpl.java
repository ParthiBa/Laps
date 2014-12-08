package com.team6.LapsApp.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team6.LapsApp.model.Employee;
import com.team6.LapsApp.model.LeaveDetail;
import com.team6.LapsApp.model.Manager;
import com.team6.LapsApp.model.OTDetail;
import com.team6.LapsApp.repository.OTDetailsCRUDRepository;
import com.team6.LapsApp.repository.leavedetailsCRUDRepository;
import com.team6.LapsApp.repository.LeaveDetailsRepository;
import com.team6.LapsApp.repository.ManagerRepository;
import com.team6.LapsApp.repository.employeeRepostitory;

@Service
public class LeaveApplicationServiceImpl implements LeaveApplicationService{

	@Resource
	private employeeRepostitory m_empRepository;
	@Resource
	private LeaveDetailsRepository m_leaveRepository;
	@Resource
	private leavedetailsCRUDRepository m_leavedetailscrud;
	@Resource
	private ManagerRepository m_managerRepository;
	@Resource
	private OTDetailsCRUDRepository m_otRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<LeaveDetail> ListPersonTookMaxLeave() {
		List<LeaveDetail> result = null;
		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public Employee findById(String id) {
		return m_empRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public void CreateEmployeeID() {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(readOnly = true)
	public void UpdateEmployeeID() {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(readOnly = true)
	public void DeleteEmployeeID() {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(readOnly = true)
	public void CreateLeaveType() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CreateNewRole() {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void ApplyLeave(LeaveDetail ld) {
		LeaveDetail ldlocal = ld;
		ldlocal.setEmployeeID("E02");
		ldlocal.setRoleID("E");
		ldlocal.setLeaveTypeID("AN");
		Calendar calendar = Calendar.getInstance();
		// get a java date (java.util.Date) from the Calendar instance.
		// this java date will represent the current date, or "now".
		java.util.Date currentDate = calendar.getTime();
		 
		// now, create a java.sql.Date from the java.util.Date
		java.sql.Date date1 = new java.sql.Date(currentDate.getTime());
		java.sql.Date date2 = new java.sql.Date(currentDate.getTime()+20000);
		ldlocal.setFromDate(date1);
		ldlocal.setToDate(date2);
		ldlocal.setNUmberOfDays(1.0);
		ldlocal.setLeaveStatus("Applied");
		ldlocal.setWorkDissemination("E02");
		m_leavedetailscrud.saveAndFlush(ldlocal);
	}

	@Override
	@Transactional(readOnly = true)
	public void ApplyClaim(OTDetail ot) {
		OTDetail localot = ot;
		localot.m_itID.setEmployeeID("E02");
		localot.setIsApproved(false);
		localot.setIsFullDay(true);
		Calendar calendar = Calendar.getInstance();
		// get a java date (java.util.Date) from the Calendar instance.
		// this java date will represent the current date, or "now".
		java.util.Date currentDate = calendar.getTime();
		 
		// now, create a java.sql.Date from the java.util.Date
		java.sql.Date date1 = new java.sql.Date(currentDate.getTime());
		localot.m_itID.setM_otWorkedDate(date1);
		m_otRepository.saveAndFlush(ot);
	}

	@Override
	@Transactional(readOnly = true)
	public Manager findManagerByID(String empid) {
		return m_managerRepository.findOne(empid);
	}

}
