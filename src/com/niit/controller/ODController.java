package com.niit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.model.Food;
import com.niit.model.OrderDetail;
import com.niit.model.Orders;
import com.niit.service.ODService;

@Controller
public class ODController {
	
	// 注入Service层的接口
	@Autowired // byType的自动注入  
	private ODService odService;
	
	@RequestMapping("/{orderId}/orderDetail.do")
	public String list(OrderDetail orderDetail,
			Orders orders,
			Map<String,Object> map,
			@PathVariable("orderId")int orderId){
		
	List<OrderDetail> list = odService.getAll(orderId);
		map.put("list",list);
		
		odService.CountPrice(orders);
		
		return "orderDetail";
	}
	
	@RequestMapping("/{orderId}/orderDetail2.do")
	public String list2(OrderDetail orderDetail,
			Orders orders,
			Map<String,Object> map,
			@PathVariable("orderId")int orderId){
		
	List<OrderDetail> list = odService.getAll(orderId);
		map.put("list",list);
		
		odService.CountPrice(orders);
		
		return "orderDetail2";
	}
	
	@RequestMapping("/{orderId}/{id}/AdditionFood.do")
	public String AdditionFood(Food food,
			OrderDetail orderDetail,
			@PathVariable("orderId")int orderId,
			@PathVariable("id")int id){
		
		odService.AdditionFood(food);
		
		return"redirect:/{orderId}/orderDetail.do";
	}
	
	@RequestMapping("/{orderId}/{id}/SubtractionFood.do")
	public String SubtractionFood(Food food,OrderDetail orderDetail,
			@PathVariable("orderId")int orderId,
			@PathVariable("id")int id){
		
		odService.SubtractionFood(food);
		
		return"redirect:/{orderId}/orderDetail.do";
	}
	
	@RequestMapping("/{orderId}/{id}/cancel.do")
	public String cancel(OrderDetail orderDetail,
			@PathVariable("orderId")int orderId,
			@PathVariable("id")int id){
		
		odService.cancel(orderDetail);
		
		return"redirect:/{orderId}/orderDetail.do";
	}
}
