package com.team6.LapsApp.service;

import java.util.List;

import com.team6.LapsApp.model.*;

public interface LeaveDetailsService {

	public List<LeaveDetail> FinfPersonalLeaveHistroy(String empID);
	public List<LeaveDetail> FindAllLeave();
	public List<LeaveDetail> ListMaxLeavesList();
}
