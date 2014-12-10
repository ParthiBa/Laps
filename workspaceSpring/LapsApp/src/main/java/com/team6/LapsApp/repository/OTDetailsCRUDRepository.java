package com.team6.LapsApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team6.LapsApp.model.OTDetail;
import com.team6.LapsApp.model.OTDetailsCompositeID;

public interface OTDetailsCRUDRepository extends JpaRepository<OTDetail, OTDetailsCompositeID>{
	
	@Query("SELECT s FROM OTDetail s WHERE s.m_itID.employeeID=(:empID) AND s.isApproved= TRUE")
	List<OTDetail> findleave(@Param("empID") String empID);
}
