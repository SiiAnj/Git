package com.niit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.model.DinnerTable;
import com.niit.model.FoodType;
import com.niit.page.Page;
import com.niit.service.FTService;

@Controller
public class FTController {
	
	// 注入Service层的接口
	@Autowired // byType的自动注入  
	private FTService ftService;
	
	//查询
	@RequestMapping("/cuisineList.do")
	public String list(Map<String,Object> map,
			Page page){
		
		// 查询总的数据行数
		int totalCount = ftService.getTotalCount();
		page.setTotalCount(totalCount);// 一定要设置到 page类中
		
		List<FoodType> list = ftService.getAll(page);
		map.put("list",list);
		
		return "cuisineList";
	}
	
	//添加菜系1. 跳转到saveCuisine.jsp
	@RequestMapping("/toSaveBoard.do")
	public String toSaveBoard(){
		
		return"saveCuisine";
	}
	
	//添加菜系2.执行添加方法
	@RequestMapping("/saveCuisine.do")
	public String SaveBoard(FoodType foodType){
		
		ftService.save(foodType);
		return"redirect:/cuisineList.do"; // redirect: 不经过视图解析器 直接跳转
	}
	
	
	//更新菜系名1.跳转updateCuisine.jsp
	@RequestMapping("/{id}/toUpdateCuisine.do")
	public String toUpdate (@PathVariable("id") int id,
			Map<String,Object> map){
		
		FoodType FT = ftService.findById(id);
		map.put("FT", FT);
		
		return"updateCuisine";
	}
	
	//更新菜系名2.执行更新方法
	@RequestMapping("/updateCuisine.do")
	public String updateCuisine(FoodType foodType){
		
		ftService.update(foodType);
		return"redirect:/cuisineList.do";
	}
	
	//删除餐桌
	@RequestMapping("/{id}/deleteCuisine.do")
	public String deleteCuisine(@PathVariable("id") int id){
		ftService.delete(id);
		
		return "redirect:/cuisineList.do";// 返回到cuisineList.do 重新查询数据
	}
}
