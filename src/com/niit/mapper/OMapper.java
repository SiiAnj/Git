package com.niit.mapper;

import java.util.List;

import com.niit.model.Orders;
import com.niit.page.Page;


public interface OMapper {

	//查询所有餐厅订单
	public List<Orders> getAll(Page page);
	
	public int getTotalCount();
	
	public void unsubscribeO(Orders orders);
	
	public void unsubscribeDT();
	
	public void bill(Orders orders);
	
	/*public void CloseForeignKey();
	
	//添加菜系
	public void save(Food food);
	
	
	//最后id
	public void getLast(int id);
	
	//
	public void upImg(Food food);
	
	
	public void OpenForeignKey();
	
	//查询菜系主键
	public Food findById(int id);
	
	public Food findByName(String foodName);
	
	//更新菜系
	public void update(Food food);
	
	//删除菜系
	public boolean delete(int id);
	
	public Food getFoodTypeOfFood(int id);*/
}
