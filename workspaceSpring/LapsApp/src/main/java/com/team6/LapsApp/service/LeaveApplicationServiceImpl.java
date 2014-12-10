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
import com.team6.LapsApp.model.Entitlement;
import com.team6.LapsApp.model.Holiday;
import com.team6.LapsApp.model.LeaveDetail;
import com.team6.LapsApp.model.LeaveDetailCompositeID;
import com.team6.LapsApp.model.LeaveType;
import com.team6.LapsApp.model.Manager;
import com.team6.LapsApp.model.OTDetail;
import com.team6.LapsApp.model.OTDetailsCompositeID;
import com.team6.LapsApp.repository.EntilementReposistory;
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
	 
	@Resource
	private EntilementReposistory entilementReposistory;
	@Override
	@Transactional(readOnly = true)
	public List<LeaveDetail> ListPersonTookMaxLeave() {
		List<LeaveDetail> result = null;
		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public Employee findEmployee(String id) {
		Employee e= m_empRepository.findOne(id);
		return e;
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
		Manager m = m_managerRepository.findOne(empid);
		return m;
	}

	@Override
	public LeaveDetail GetLeaveById(LeaveDetailCompositeID key) {
		return m_leavedetailscrud.findOne(key);
	}
	@Override
	public OTDetail GetotId(OTDetailsCompositeID ot)
	{
		return m_otRepository.findOne(ot);
	}
	
	@Override
	public void LeaveDetailsUpdate(LeaveDetail ld) {
		m_leavedetailscrud.save(ld);
	}
	@Override
	public void CLaimDetailsUpdate(OTDetail ot)
	{
		m_otRepository.saveAndFlush(ot);
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

	@Override
	public void CreateManager(Manager e) {
		m_managerRepository.save(e);
	}

	@Override
	public void UpdateManager(Manager e) {
		Manager toUpdateemp = m_managerRepository.findOne(e.getEmployeeID());
		if(toUpdateemp!=null)
		{
			toUpdateemp.setDob(e.getDob());
			toUpdateemp.setRoleID(e.getRoleID());
			toUpdateemp.setEmployeename(e.getEmployeename());
		}
	}

	@Override
	public Manager DeleteManager(String empid) {
		boolean x = m_managerRepository.exists(empid);
        Manager emp=m_managerRepository.findOne(empid);
        if(x)
        {
        	m_managerRepository.delete(emp);
        }
		return emp;
	}
	@Override
	public Manager findManagerByUserNamePassword(String empid, String password) {
		// TODO Auto-generated method stub
	Manager m=	m_managerRepository.FindManagerByUandPassword(empid, password);
	return m;
	}
	
	public List<EmployeeRole> findAllEmployeeRole()
	{
      return	(List<EmployeeRole>) roleRepository.findAll();	
	}
	
	
	public EmployeeRole deleteEmployeeRole (String roleid)
	{
		EmployeeRole obj=roleRepository.findOne(roleid);
		roleRepository.delete(obj);
		return obj;
		
	}
	
	@Transactional
	public EmployeeRole CreateEmpRole(EmployeeRole newRole)
	{
		return roleRepository.save(newRole);
	}

	/*@Override
	public Employee findAdmin(String username, String password) {
		// TODO Auto-generated method stub
		Employee e= m_empRepository.FindAdmin(username, password);
		return e;
	}*/

	@Override
	public Employee findEmp(String username, String password) {
		// TODO Auto-generated method stub
		Employee e =m_empRepository.FindEmp(username, password);
		return e;
	}
	
	
	@Transactional
	public Entitlement update(Entitlement e) {
		
		Entitlement updatedEntitlement = entilementReposistory.findByOne(e.getRoleId(),e.getLeaveTypeId());
		updatedEntitlement.setRoleId(e.getRoleId());
		updatedEntitlement.setLeaveTypeId(e.getLeaveTypeId());
		updatedEntitlement.setNumOfDays(e.getNumOfDays());
		updatedEntitlement.setApprovelRoleId(e.getApprovelRoleId());
	
		return updatedEntitlement;
	}



	@Override
	@Transactional
	public List<Entitlement> findAll() {
		
		return (List<Entitlement>) entilementReposistory.findAll();	}



	@Transactional
	public Entitlement delete(Entitlement e) {
		
		Entitlement deletedEntitlement = entilementReposistory.findByOne(e.getRoleId(),e.getLeaveTypeId());
		entilementReposistory.delete(deletedEntitlement);
		return deletedEntitlement;
	}

	
	@Transactional
	@Override
	public List<EmployeeRole> findRoleAll() {
		// TODO Auto-generated method stub
		return (List<EmployeeRole>) roleRepository.findAll();
	}

	@Override
	@Transactional
	public List<LeaveType> findLeaveAll() {
		return (List<LeaveType>) lr.findAll();
	}


	@Transactional
	public Entitlement create(Entitlement e) {
		Entitlement createdEntitlement = e;
		return entilementReposistory.save(createdEntitlement);
	}

	@Override
	public Entitlement findByOne(String rid, String lid) {
		// TODO Auto-generated method stub
		return entilementReposistory.findByOne(rid, lid);
	}
	
	@Override
	public Manager findbykey(String empID)
	{
		Manager m=m_managerRepository.FindManagerByU(empID);
		return m;
	}
}
