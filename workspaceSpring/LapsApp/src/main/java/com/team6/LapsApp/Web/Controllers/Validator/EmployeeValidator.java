package com.team6.LapsApp.Web.Controllers.Validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

import com.team6.LapsApp.model.Employee;

@Component 
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
	    
		return Employee.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Employee employee=(Employee) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeename", "Employee.employeename.empty");
	    ValidationUtils.rejectIfEmpty(errors, "dob","Employee.dob.empty");
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Employee.password.empty");
	    if(employee.getRoleID().equals("-"))
	    {
	    	errors.rejectValue("roleID","Employee.roleID.empty");
	    	
	    }
	    if(employee.getSuperVisorID().equals("-"))
	    {
	    	errors.rejectValue("supervisorID","Employee.supervisorID.empty") ;
	    }
		
	}

}
