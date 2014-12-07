package com.team6.LapsApp.service;

import java.util.List;

import javax.annotation.Resource;

import com.team6.LapsApp.model.EmployeeRole;
import com.team6.LapsApp.repository.RoleIDReposistory;
public class EmployeeRoleServiceImpl implements EmployeeRoleService {

	
	@Resource
	private RoleIDReposistory roleRepository;
	
	public List<EmployeeRole> findAll() {
	
		return (List<EmployeeRole>) roleRepository.findAll();
	}

}
