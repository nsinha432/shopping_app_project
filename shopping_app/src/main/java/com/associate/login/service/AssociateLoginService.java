package com.associate.login.service;

import com.app.exception.BusinessException;

public interface AssociateLoginService {
	
	public boolean checkUserName(String username) throws BusinessException;
	
	public boolean checkPassword(String password) throws BusinessException;
	
}
