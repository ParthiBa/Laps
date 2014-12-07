package com.team6.LapsApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team6.LapsApp.model.Employee;
import com.team6.LapsApp.model.LeaveDetail;
import com.team6.LapsApp.model.Manager;
import com.team6.LapsApp.model.OTDetail;
import com.team6.LapsApp.repository.LeaveDetailsRepository;
import com.team6.LapsApp.repository.ManagerRepository;
import com.team6.LapsApp.repository.employeeRepostitory;
import com.team6.LapsApp.repository.SpringDataJpa.SpringLeaveDetailsCrud;

@Service
public class LeaveApplicationServiceImpl implements LeaveApplicationService{

	private employeeRepostitory m_empRepository;
	private LeaveDetailsRepository m_leaveRepository;
	private SpringLeaveDetailsCrud m_leavecrudrepo;
	private ManagerRepository m_managerRepository;
	
    @Autowired
	public LeaveApplicationServiceImpl(employeeRepostitory er,LeaveDetailsRepository ldr,SpringLeaveDetailsCrud ldcr,ManagerRepository mr)
	{
		m_empRepository = er;
		m_leaveRepository = ldr;
		m_leavecrudrepo = ldcr;
		m_managerRepository = mr;	
	}
	/*@Override
	public List<LeaveDetail> FindLeaveApplicationForApproval(String empid) {
		m_leaveRepository.
		return null;
	}

	@Override
	public List<OTDetail> FindClaimApplicationForApproval(String empid) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	@Transactional(readOnly = true)
	public List<LeaveDetail> ListPersonTookMaxLeave() {
		List<LeaveDetail> result = null;
		result = m_leaveRepository.ListPersonTookMaxLeave();
		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public List<LeaveDetail> FindPersonalLeaves(String empid) {
		List<LeaveDetail> result = null;
		//result = m_empRepository.findPersonalLeaveHistory(empID);
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
	@Transactional(readOnly = true)
	public void ApplyLeave(LeaveDetail ld) {
		m_leavecrudrepo.save(ld);
		
	}

	@Override
	@Transactional(readOnly = true)
	public void ApplyClaim(String empID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(readOnly = true)
	public Manager findManagerByID(String empid) {
		return m_managerRepository.findOne(empid);
	}

}
