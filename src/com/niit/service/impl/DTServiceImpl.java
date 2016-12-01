package com.niit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mapper.DTMapper;
import com.niit.model.DinnerTable;
import com.niit.model.Food;
import com.niit.model.OrderDetail;
import com.niit.model.Orders;
import com.niit.page.Page;
import com.niit.service.DTService;


@Service // 相当于是将此类交给Spring管理  相当于在applicationContext.xml中定义一个 bean
@Transactional // 告诉Spring 该类中所有事物 都有Spring配置文件中 事务管理器去管理
public class DTServiceImpl implements DTService {

	// 注入mapper Spring帮我们调用mapper中的方法
	@Resource //资源 byName注入
	private DTMapper dtMapper;
	
	@Override
	public List<DinnerTable> getAll(Page page) {
		
		return dtMapper.getAll(page);
	}

	@Override
	public int getTotalCount() {
		
		return dtMapper.getTotalCount();
	}

	@Override
	public void save(DinnerTable dinnerTable) {
		dtMapper.save(dinnerTable);
	}

	@Override
	public void reserve(DinnerTable dinnerTable) {
		dtMapper.reserve(dinnerTable);
		
	}

	@Override
	public void unsubscribe(DinnerTable dinnerTable) {
		dtMapper.unsubscribe(dinnerTable);
		
	}

	@Override
	public boolean delete(int id) {
		
		return dtMapper.delete(id);
	}

	@Override
	public void insertOrder(Orders orders) {
		dtMapper.insertOrder(orders);
		
	}

	@Override
	public void updateOrder() {
		dtMapper.updateOrder();
		
	}

	@Override
	public int foodCount() {
		return dtMapper.foodCount();
		
	}

	@Override
	public void insertorderFood(Food food) {
		dtMapper.insertorderFood(food);
		
	}

	@Override
	public void insertorderOrderDetail(OrderDetail orderDetail) {
		dtMapper.insertorderOrderDetail(orderDetail);
		
	}
}
