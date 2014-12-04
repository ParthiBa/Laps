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
	
	
//
//	@Override
//	@Transactional
//	public Student create(Student s) {
//		Student createdStudent = s;
//		return studentRepository.save(createdStudent);
//	}
	
	@Override
	@Transactional
	public Employee findById(String id) {
		return er.findOne(id);
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

}
