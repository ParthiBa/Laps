package com.team6.LapsApp.Web.Controllers.Validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.team6.LapsApp.model.Entitlement;


@Component
public class EntitlementValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Entitlement.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Entitlement e = (Entitlement)target;
		ValidationUtils.rejectIfEmpty(errors, "roleId", "entitlement.roleId.empty");
		ValidationUtils.rejectIfEmpty(errors, "leaveTypeId", "entitlement.leaveTypeId.empty");
		ValidationUtils.rejectIfEmpty(errors, "numOfDays", "entitlement.numOfDays.empty");
		ValidationUtils.rejectIfEmpty(errors, "approvelRoleId", "entitlement.approvelRoleId.empty");
		
	}

}
