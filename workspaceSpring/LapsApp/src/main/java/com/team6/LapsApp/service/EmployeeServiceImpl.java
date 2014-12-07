package com.team6.LapsApp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team6.LapsApp.model.Employee;
import com.team6.LapsApp.model.LeaveDetail;
import com.team6.LapsApp.repository.employeeRepostitory;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Resource
    private employeeRepostitory er;
	
	

	@Transactional
	public Employee create(Employee s) {
		Employee createdEmployee = s;
		return er.save(createdEmployee);
	}
	
	@Override
	@Transactional
	public Employee findById(String id) {
		return er.findOne(id);
	}
	


	@Transactional
	public List<Employee> ListOfSuperVisor() {
		// TODO Auto-generated method stub
		return er.ListOfSuperVisor();
	}


//	@Override
//	@Transactional(rollbackFor=StudentNotFound.class)
//	public Student delete(long id) throws StudentNotFound {
//		Student deletedStudent = studentRepository.findOne(id);
//		
//		if (deletedStudent == null)
//			throw new StudentNotFound();
//		
//		studentRepository.delete(deletedStudent);
//		return deletedStudent;
//	}
//
//	@Override
//	@Transactional
//	public List<Student> findAll() {
//		return studentRepository.findAll();
//	}
//
//	@Override
//	@Transactional(rollbackFor=StudentNotFound.class)
//	public Student update(Student s) throws StudentNotFound {
//		Student updatedStudent = studentRepository.findOne(s.getId());
//		
//		if (updatedStudent== null)
//			throw new StudentNotFound();
//		
//		updatedStudent.setName(s.getName());
//		updatedStudent.setNick(s.getNick());
//		updatedStudent.setFee(s.getFee());
//		updatedStudent.setGrade(s.getGrade());
//		studentRepository.flush();
//		return updatedStudent;
//	}
	
	@Override
	@Transactional
	public Employee update(Employee s) 
	
	{
		Employee toUpdateemp = er.findOne(s.getEmployeeID());
		if(er!=null)
		{
			toUpdateemp.setDob(s.getDob());
			toUpdateemp.setRoleID(s.getRoleID());
			toUpdateemp.setEmployeename(s.getEmployeename());
			toUpdateemp.setSupervisorID(s.getSupervisorID());
			

		}
		return toUpdateemp;
	}
	


	@Override
@Transactional
	public Employee delete(String id) {
		// TODO Auto-generated method stub
            boolean x = er.exists(id);
            
            Employee emp=er.findOne(id);
            if(x)
            {
            	er.delete(emp);
            }
            return emp;
            
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
	 
	return  (List<Employee>) er.findAll();
	}



	@Override
	public List<Employee> SearchEmpbyName(String na) {
		return er.SearchbyName(na);
	}

}
