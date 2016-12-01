package com.niit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.model.Orders;
import com.niit.page.Page;
import com.niit.service.DTService;
import com.niit.service.OService;

@Controller
public class OController {
	
	// 注入Service层的接口
	@Autowired // byType的自动注入  
	private OService oService;
	@Autowired
	private DTService dtService;
	
	//查询
	@RequestMapping("/orderList.do")
	public String list(Map<String,Object> map,
			Page page){
		
		// 查询总的数据行数
		int totalCount = oService.getTotalCount();
		page.setTotalCount(totalCount);// 一定要设置到 page类中
		
		List<Orders> list = oService.getAll(page);
		map.put("list",list);
		
		return "orderList";
	}
	
	@RequestMapping("/{id}/unsubscribeO.do")
	public String updateOrders(Orders orders,
			@PathVariable("id")int id){
		
		/*oService.unsubscribeDT();*/
		oService.unsubscribeO(orders);
		
		return"redirect:/orderList.do";
	}
	

	@RequestMapping("/{id}/bill.do")
	public String bill(Orders orders,
			@PathVariable("id")int id){
		
		oService.bill(orders);
		
		return "redirect:/orderList.do";
	}
}
