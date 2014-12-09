package com.team6.LapsApp.Web.Controllers.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.team6.LapsApp.Web.Controllers.Validator.UserModel;

public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors erros) {
		// TODO Auto-generated method stub

	}

}
