package com.associate.login.service.impl;

import com.app.exception.BusinessException;
import com.associate.login.service.AssociateLoginService;

public class AssociateLoginServiceImpl implements AssociateLoginService{

	@Override
	public boolean checkUserName(String username) throws BusinessException {
		boolean c = false;
		
		String adminUser = "admin";
		
		if(username.equals(adminUser)) {
			c= true;
		}
		else {
			throw new BusinessException("Invalid username : "+ username);
		}
		
		return c;
	}

	@Override
	public boolean checkPassword(String password) throws BusinessException {
		boolean c = false;
		
		String adminPass = "admin@123";
		
		if(password.equals(adminPass)) {
			c = true;
		}
		else {
			throw new BusinessException("Invalid password");
		}
		
		return c;
	}

}
