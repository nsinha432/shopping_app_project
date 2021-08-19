package com.cart.dao.service;

import com.app.exception.BusinessException;

public interface CartDAOService {
	public boolean checkProductID(int orderId) throws BusinessException;
}
