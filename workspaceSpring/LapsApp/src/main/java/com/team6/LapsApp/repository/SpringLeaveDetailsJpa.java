package com.team6.LapsApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team6.LapsApp.model.LeaveDetail;
import com.team6.LapsApp.model.LeaveDetailCompositeID;
import com.team6.LapsApp.repository.LeaveDetailsRepository;
import com.team6.LapsApp.model.LeaveDetail;

public interface SpringLeaveDetailsJpa extends LeaveDetailsRepository, JpaRepository<LeaveDetail, LeaveDetailCompositeID> {
	
	@Override
    @Query("SELECT s FROM LeaveDetail s WHERE LOWER(s.id.employeeID) = LOWER(:empID)")
    List<LeaveDetail> findPersonalLeaveHistory(@Param("empID") String empID);
	
	@Override
    @Query("SELECT s FROM LeaveDetail s")
	List<LeaveDetail> FindAllLeave();
	
	@Override
    @Query("SELECT s FROM LeaveDetail s group by s.id.employeeID")
	List<LeaveDetail> ListPersonTookMaxLeave();
	
	
	@Override
	@Query("SELECT s From LeaveDetail s WHERE s.id.employeeID=(:empID) AND s.leaveTypeID=(:leave)")
	List<LeaveDetail> ListofleaveTaken(@Param("empID") String empID,@Param("leave") String leave);
	
	
	

}
