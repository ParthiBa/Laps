package com.team6.LapsApp.service;

import java.util.List;

import javax.annotation.Resource;

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

	@Resource
	private employeeRepostitory m_empRepository;
	@Resource
	private LeaveDetailsRepository m_leaveRepository;
	@Resource
	private SpringLeaveDetailsCrud m_leavecrudrepo;
	@Resource
	private ManagerRepository m_managerRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<LeaveDetail> ListPersonTookMaxLeave() {
		List<LeaveDetail> result = null;
		result = m_leaveRepository.ListPersonTookMaxLeave();
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
		//m_leavecrudrepo.save(ldlocal);
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
