package com.team6.LapsApp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.team6.LapsApp.model.LeaveDetail;
import com.team6.LapsApp.repository.LeaveDetailsRepository;

@Service
public class LeaveDetailsServiceImpl implements LeaveDetailsService{

	@Resource
	private LeaveDetailsRepository m_repository;
	
	@Override
	public List<LeaveDetail> FinfPersonalLeaveHistroy(String empID) {
		List<LeaveDetail> result = null;
		result = m_repository.findPersonalLeaveHistory(empID);
		return result;
	}
	
	@Override
	public List<LeaveDetail> FindAllLeave() {
		List<LeaveDetail> result = null;
		result = m_repository.FindAllLeave();
		return result;
	}

	@Override
	public List<LeaveDetail> ListPersonTookMaxLeave() {
		List<LeaveDetail> result = null;
		result = m_repository.ListPersonTookMaxLeave();
		return result;
	}
}
