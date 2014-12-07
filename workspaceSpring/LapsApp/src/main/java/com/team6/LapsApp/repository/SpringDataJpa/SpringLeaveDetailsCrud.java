package com.team6.LapsApp.repository.SpringDataJpa;

import org.springframework.data.repository.CrudRepository;

import com.team6.LapsApp.model.LeaveDetail;

public interface SpringLeaveDetailsCrud extends CrudRepository<LeaveDetail,String>{
	

}
