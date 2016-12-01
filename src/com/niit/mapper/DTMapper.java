package com.niit.mapper;

import java.util.List;

import com.niit.model.DinnerTable;
import com.niit.model.Food;
import com.niit.model.OrderDetail;
import com.niit.model.Orders;
import com.niit.page.Page;

public interface DTMapper {

	// 查询所有餐桌
	public List<DinnerTable> getAll(Page page);
	
	public int getTotalCount();
	
	//添加餐桌
	public void save(DinnerTable dinnerTable);
	
	//预定餐桌
	public void reserve(DinnerTable dinnerTable);
	
	public void insertOrder(Orders orders);
	
	public void insertorderFood(Food food);
	
	public void insertorderOrderDetail(OrderDetail orderDetail);
	
	public int foodCount();
	
	//退定餐桌
	public void unsubscribe(DinnerTable dinnerTable);
	
	public void updateOrder();
	
	//删除餐桌
	public boolean delete(int id);
}
