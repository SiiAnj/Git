package com.niit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.model.DinnerTable;
import com.niit.model.Food;
import com.niit.model.OrderDetail;
import com.niit.model.Orders;
import com.niit.page.Page;
import com.niit.service.DTService;

@Controller
public class DTController {
	
	// 注入Service层的接口
	@Autowired // byType的自动注入  
	private DTService dtService;
	
	@RequestMapping("/boardList.do")
	public String list(Map<String,Object> map,
			Page page){
		
		// 查询总的数据行数
		int totalCount = dtService.getTotalCount();
		page.setTotalCount(totalCount);// 一定要设置到 page类中
		
		List<DinnerTable> list = dtService.getAll(page);
		map.put("list",list);
		
		return "boardList";
	}
	
	//添加餐桌1. 跳转到SaveBoard.jsp
	@RequestMapping("/toSaveCuisine.do")
	public String toSaveCuisine(){
		
		return"saveBoard";
	}
	
	//添加餐桌2.执行添加方法
	@RequestMapping("/saveBoard.do")
	public String SaveBoard(DinnerTable dinnerTable){
		
		dtService.save(dinnerTable);
		return"redirect:/boardList.do"; // redirect: 不经过视图解析器 直接跳转
	}
	
	//预定餐桌
	@RequestMapping("/{id}/reserve.do")
	public String reserve(DinnerTable dinnerTable,
			Orders orders,
			OrderDetail orderDetail,
			Food food,
			@PathVariable("id") int id){
		
		dtService.reserve(dinnerTable);
		
		dtService.insertOrder(orders);
		
		dtService.insertorderFood(food);
		
		dtService.insertorderOrderDetail(orderDetail);
		return"redirect:/boardList.do";
	}
	
	//退定餐桌
	@RequestMapping("/{id}/unsubscribe.do")
	public String unsubscribe(DinnerTable dinnerTable,
			@PathVariable("id") int id){
			
		dtService.updateOrder();
		
		dtService.unsubscribe(dinnerTable);
		
		return"redirect:/boardList.do";
	}
	
	//删除餐桌
	@RequestMapping("/{id}/delete.do")
	public String delete(@PathVariable("id") int id){
		dtService.delete(id);
		
		return "redirect:/boardList.do";// 返回到index.do 重新查询数据
	}
}
