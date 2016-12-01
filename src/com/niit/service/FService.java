package com.niit.service;

import java.util.List;

import com.niit.model.Food;
import com.niit.page.Page;


public interface FService {

	//查询所有菜系
	public List<Food> getAll(Page page);
	
	public int getTotalCount();
	
	public void CloseForeignKey();
	
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
	
	
}
