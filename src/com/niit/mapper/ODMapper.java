package com.niit.mapper;

import java.util.List;

import com.niit.model.Food;
import com.niit.model.OrderDetail;
import com.niit.model.Orders;

public interface ODMapper {
	
	public List<OrderDetail> getAll(int id);
	
	public List<Food> getFood();
	
	public List<OrderDetail> getOD();
	
	public void AdditionFood(Food food);
	
	public void AdditionOD(OrderDetail orderDetail);
	
	public void CountPrice(Orders orders);
	
	public void updateOId(OrderDetail orderDetail);
	
	public void SubtractionFood(Food food);
	
	public void cancel(OrderDetail orderDetail);
	
	public void updateOD(OrderDetail orderDetail);
	
	
}
