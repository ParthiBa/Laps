package com.team6.LapsApp.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team6.LapsApp.model.Employee;
import com.team6.LapsApp.model.EmployeeRole;
import com.team6.LapsApp.model.Holiday;
import com.team6.LapsApp.model.LeaveDetail;
import com.team6.LapsApp.model.LeaveDetailCompositeID;
import com.team6.LapsApp.model.LeaveType;
import com.team6.LapsApp.model.Manager;
import com.team6.LapsApp.model.OTDetail;
import com.team6.LapsApp.repository.HolidayReposistory;
import com.team6.LapsApp.repository.LeaveTypeRepository;
import com.team6.LapsApp.repository.OTDetailsCRUDRepository;
import com.team6.LapsApp.repository.RoleIDReposistory;
import com.team6.LapsApp.repository.SpringLeaveDetailsJpa;
import com.team6.LapsApp.repository.StaffRepository;
import com.team6.LapsApp.repository.ManagerRepository;


@Service
public class LeaveApplicationServiceImpl implements LeaveApplicationService{

	@Resource
	private StaffRepository m_empRepository;
	@Resource
	private SpringLeaveDetailsJpa m_leavedetailscrud;
	@Resource
	private ManagerRepository m_managerRepository;
	@Resource
	private OTDetailsCRUDRepository m_otRepository;
	@Resource
	private RoleIDReposistory roleRepository;
	@Resource
	private HolidayReposistory hr;
	@Resource
    private LeaveTypeRepository lr;
	
	@Override
	@Transactional(readOnly = true)
	public List<LeaveDetail> ListPersonTookMaxLeave() {
		List<LeaveDetail> result = null;
		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public Employee findEmployee(String id) {
		return m_empRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public void CreateEmployeeID(Employee e) {
		Employee createdEmployee = e;
		m_empRepository.save(createdEmployee);
	}

	@Override
	@Transactional(readOnly = true)
	public void UpdateEmployeeID(Employee s) {
		Employee toUpdateemp = m_empRepository.findOne(s.getEmployeeID());
		if(m_empRepository!=null)
		{
			toUpdateemp.setDob(s.getDob());
			toUpdateemp.setRoleID(s.getRoleID());
			toUpdateemp.setEmployeename(s.getEmployeename());
			toUpdateemp.setSuperVisorID(s.getSuperVisorID());
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Employee DeleteEmployeeID(String empid) {
		boolean x = m_empRepository.exists(empid);
        Employee emp=m_empRepository.findOne(empid);
        if(x)
        {
        	m_empRepository.delete(emp);
        }
		return emp;
	}

	@Override
	public void CreateNewRole(EmployeeRole er) {
		roleRepository.save(er);
	}

	@Override
	@Transactional
	public void ApplyLeave(LeaveDetail ld) {
		LeaveDetail ldlocal = ld;
		m_leavedetailscrud.saveAndFlush(ldlocal);
	}

	@Override
	@Transactional(readOnly = true)
	public void ApplyClaim(OTDetail ot) {
		OTDetail localot = ot;
		m_otRepository.saveAndFlush(localot);
	}

	@Override
	@Transactional(readOnly = true)
	public Manager findManagerByID(String empid) {
		return m_managerRepository.findOne(empid);
	}

	@Override
	public LeaveDetail GetLeaveById(LeaveDetailCompositeID key) {
		return m_leavedetailscrud.findOne(key);
	}

	@Override
	public void LeaveDetailsUpdate(LeaveDetail ld) {
		m_leavedetailscrud.save(ld);
	}

	@Override
	public Employee updateEmployeeDetails(Employee s) {
		Employee toUpdateemp = m_empRepository.findOne(s.getEmployeeID());
		if(toUpdateemp!=null)
		{
			toUpdateemp.setDob(s.getDob());
			toUpdateemp.setRoleID(s.getRoleID());
			toUpdateemp.setEmployeename(s.getEmployeename());
			toUpdateemp.setSuperVisorID(s.getSuperVisorID());
		}
		return toUpdateemp;
	}

	@Override
	public List<Manager> ListOfSuperVisor() {
		return (List<Manager>)m_managerRepository.findAll();
	}
	
	@Override
	public void CreateLeaveType(LeaveType lt) {
		LeaveType createdLeaveType = lt;
		lr.save(createdLeaveType);
	}

	@Override
	public List<LeaveType> GetAllLeaveTypes() {
		return  (List<LeaveType>) lr.findAll();
	}

	@Override
	public LeaveType DeleteLeaveType(String lt) {
		boolean x = lr.exists(lt);
        
        LeaveType leavetype=lr.findOne(lt);
        if(x)
        {
        	lr.delete(leavetype);
        }
        return leavetype;
	}

	@Override
	public void CreateHoliday(Holiday hl) {
		Holiday createHoliday = hl;
		hr.save(createHoliday);
	}

	@Override
	public Holiday DeleteHoliday(String hl) {
		boolean x = hr.exists(hl);
        Holiday holiday=hr.findOne(hl);
        if(x)
        {
        	hr.delete(holiday);
        }
        return holiday;
	}

	@Override
	public List<Employee> SearchEmpbyName(String na) {
		m_empRepository.SearchbyName(na);
		return null;
	}

	@Override
	public List<Holiday> GetAllHolidays() {
		return  (List<Holiday>) hr.findAll();
	}

	@Override
	public List<Employee> FindAllEmployee() {
		m_empRepository.findAll();
		return null;
	}
}
