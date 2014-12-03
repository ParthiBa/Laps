package com.team6.service;

import java.util.List;

import com.team6.LapsApp.model.Employee;



public interface EmployeeService {
	
//	public Student create(Student s);
//	public Student delete(long id) throws StudentNotFound;
//	public List<Student> findAll();
//	public Student update(Student s) throws StudentNotFound;
	public Employee findById(String id);

}
