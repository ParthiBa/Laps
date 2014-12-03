package com.team6.LapsApp.repository;
import org.springframework.data.repository.CrudRepository;

import com.team6.LapsApp.model.Employee;

public interface employeeRepostitory extends CrudRepository<Employee,String>
{

}
