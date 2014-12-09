package com.team6.LapsApp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.team6.LapsApp.model.Manager;

public interface ManagerRepository extends CrudRepository<Manager,String>{

	
	@Query("SELECT e FROM Manager e Where LOWER(e.employeeID) = LOWER(:empID) AND LOWER(e.password) = LOWER(:password)")
	Manager FindManagerByUandPassword(@Param("empID") String empID,@Param("password") String password);
}
