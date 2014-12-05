package com.team6.LapsApp.repository;

import java.util.List;

import com.team6.LapsApp.model.*;

public interface LeaveDetailsRepository {
	
	List<LeaveDetail> findPersonalLeaveHistory(String empID);
	List<LeaveDetail> FindAllLeave();
	List<LeaveDetail> ListPersonTookMaxLeave();
}
