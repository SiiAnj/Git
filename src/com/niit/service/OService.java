package com.niit.service;

import java.util.List;

import com.niit.model.Orders;
import com.niit.page.Page;


public interface OService {

	//查询所有餐厅订单
	public List<Orders> getAll(Page page);
	
	public int getTotalCount();
	
	public void unsubscribeO(Orders orders);
	
	public void unsubscribeDT();
	
	public void bill(Orders orders);
}
