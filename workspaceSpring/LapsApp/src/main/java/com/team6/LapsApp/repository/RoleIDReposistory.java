package com.team6.LapsApp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.team6.LapsApp.model.EmployeeRole;
import com.team6.LapsApp.model.Entitlement;

public interface RoleIDReposistory extends CrudRepository<EmployeeRole,String>{
	
	@Query("SELECT l FROM EmployeeRole l where l.roleId=(:roleId) ")
	public EmployeeRole findByRoleID(@Param("roleId") String roleID);

}
