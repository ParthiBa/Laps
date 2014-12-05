package com.team6.LapsApp.repository.SpringDataJpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team6.LapsApp.model.LeaveDetail;
import com.team6.LapsApp.repository.LeaveDetailsRepository;
import com.team6.LapsApp.model.LeaveDetail;

public interface SpringLeaveDetailsJpa extends LeaveDetailsRepository, JpaRepository<LeaveDetail, String> {
	
	@Override
    @Query("SELECT s FROM LeaveDetail s WHERE LOWER(s.employeeID) = LOWER(:empID)")
    List<LeaveDetail> findPersonalLeaveHistory(@Param("empID") String empID);
	
	@Override
    @Query("SELECT s FROM LeaveDetail s")
	List<LeaveDetail> FindAllLeave();
	
	@Override
    @Query("SELECT s FROM LeaveDetail s group by s.employeeID")
	List<LeaveDetail> ListPersonTookMaxLeave();
}
