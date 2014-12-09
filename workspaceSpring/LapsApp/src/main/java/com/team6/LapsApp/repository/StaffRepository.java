package com.team6.LapsApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.team6.LapsApp.model.*;

public interface StaffRepository extends CrudRepository<Employee,String>{
	
	@Query("SELECT e FROM Employee e WHERE e.roleID <> 'A' AND e.roleID <> 'E' ")
	List<Employee> ListOfSuperVisor();
	
	@Query("SELECT e FROM Employee e WHere LOWER(e.employeename) LIKE LOWER(:na)")
	List<Employee> SearchbyName(@Param("na") String na);
	@Query("SELECT e FROM Employee e WHere  e.employeeID=(:eid) AND e.password=(:password)")
	Employee FindEmp(@Param("eid") String username,@Param("password")String password);
}
