package com.cart.add.dao;

import com.app.exception.BusinessException;
import com.app.model.Cart;

public interface CartAddDAO {
	public int addToCart(String email , int productId) throws BusinessException;
}
