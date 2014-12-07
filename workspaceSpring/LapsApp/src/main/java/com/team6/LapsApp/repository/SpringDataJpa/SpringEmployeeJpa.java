package com.team6.LapsApp.repository.SpringDataJpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.team6.LapsApp.model.Employee;
import com.team6.LapsApp.repository.employeeRepostitory;

public interface SpringEmployeeJpa extends employeeRepostitory, Repository<Employee, String> {

	@Override
	@Query("SELECT DISTINCT s FROM Employee s WHERE s.employeeID=:empID")
	public Employee findById(@Param("empID") String empID);
	
	/*@Override
	@Query("SELECT s FROM Employee s left join fetch s.m_personalLeaveHistory WHERE s.id =:id")
    public Employee findById(@Param("id") String id);*/
}
