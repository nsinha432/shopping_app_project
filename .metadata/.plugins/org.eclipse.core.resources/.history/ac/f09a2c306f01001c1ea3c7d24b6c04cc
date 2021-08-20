package com.cart.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Cart;

public interface CartDAO {
	
	public List<Cart> getAllOrders() throws BusinessException;
	
	public List<Cart> getCustomerOrders(String email) throws BusinessException;
	
	public int placeOrder(int orderId, String email) throws BusinessException;
	
	public int deleteOrder(int orderId) throws BusinessException;
	
	public  int updateOrderAssociate(int orderId) throws BusinessException;
	
	public int updateOrderCustomer(int orderId) throws BusinessException;
	
	public int cartTotal(String email) throws BusinessException;
	
}
