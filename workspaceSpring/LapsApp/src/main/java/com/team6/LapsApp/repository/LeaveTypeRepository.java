package com.team6.LapsApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.team6.LapsApp.model.Entitlement;
import com.team6.LapsApp.model.LeaveType;

public interface LeaveTypeRepository extends CrudRepository<LeaveType, String>
{
	@Query("SELECT l FROM LeaveType l where l.leaveTypeID=(:leavetype) ")
	public Entitlement findByLeavetype(@Param("leavetype") String leaveType);
	
}
