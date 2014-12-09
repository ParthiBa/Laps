package com.team6.LapsApp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.team6.LapsApp.model.Entitlement;
import com.team6.LapsApp.model.EntitlementId;

public interface EntilementReposistory extends CrudRepository<Entitlement, EntitlementId> {
	
	
	@Query("SELECT leave FROM Entitlement leave WHERE leave.id.roleId = (:rid) AND leave.id.leaveTypeId = (:lid))")
	public Entitlement findByOne(@Param("rid") String eid,@Param("lid") String lid);
	
	
	
}
