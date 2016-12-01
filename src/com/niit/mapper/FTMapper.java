package com.niit.mapper;

import java.util.List;

import com.niit.model.FoodType;
import com.niit.page.Page;


public interface FTMapper {

	//查询所有菜系
	public List<FoodType> getAll(Page page);
	
	public int getTotalCount();
	
	//添加菜系
	public void save(FoodType foodType);
	
	//查询菜系主键
	public FoodType findById(int id);
	
	//更新菜系
	public void update(FoodType foodType);
	
	//删除菜系
	public boolean delete(int id);
	
	public FoodType getFoodOfFoodType(int id);
}
