package com.team6.LapsApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.team6.LapsApp.model.*;

public interface employeeRepostitory extends CrudRepository<Employee,String>
{
	@Query("SELECT e FROM Employee e WHERE e.roleID <> 'A' AND e.roleID <> 'E' ")
	List<Employee> ListOfSuperVisor();
	
	@Query("SELECT e FROM Employee e WHere LOWER(e.employeename) LIKE LOWER(:na)")
	List<Employee> SearchbyName(@Param("na") String na);
}


