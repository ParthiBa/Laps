package com.team6.LapsApp.repository.SpringDataJpa;


import org.springframework.data.jpa.repository.JpaRepository;

import com.team6.LapsApp.model.LeaveDetail;
import com.team6.LapsApp.repository.LeaveDetailsRepository;

public interface SpringLeaveDetailsJpa extends LeaveDetailsRepository, JpaRepository<LeaveDetail, String> {

}
