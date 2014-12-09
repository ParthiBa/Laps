package com.team6.LapsApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.team6.LapsApp.model.LeaveType;

public interface LeaveTypeRepository extends JpaRepository<LeaveType, String>{

}
