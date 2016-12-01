package com.niit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mapper.ODMapper;
import com.niit.model.Food;
import com.niit.model.OrderDetail;
import com.niit.model.Orders;
import com.niit.service.ODService;


@Service // 相当于是将此类交给Spring管理  相当于在applicationContext.xml中定义一个 bean
@Transactional // 告诉Spring 该类中所有事物 都有Spring配置文件中 事务管理器去管理
public class ODServiceImpl implements ODService {

	// 注入mapper Spring帮我们调用mapper中的方法
	@Resource //资源 byName注入
	private ODMapper odMapper;

	@Override
	public List<OrderDetail> getAll(int id) {
		// TODO Auto-generated method stub
		return odMapper.getAll(id);
	}

	@Override
	public List<Food> getFood() {
		
		return odMapper.getFood();
	}

	@Override
	public List<OrderDetail> getOD() {
		// TODO Auto-generated method stub
		return odMapper.getOD();
	}

	@Override
	public void AdditionFood(Food food) {
		odMapper.AdditionFood(food);
		
	}

	@Override
	public void SubtractionFood(Food food) {
		odMapper.SubtractionFood(food);
		
	}

	@Override
	public void cancel(OrderDetail orderDetail) {
		odMapper.cancel(orderDetail);
		
	}

	@Override
	public void updateOD(OrderDetail orderDetail) {
		odMapper.updateOD(orderDetail);
		
	}

	@Override
	public void AdditionOD(OrderDetail orderDetail) {
		odMapper.AdditionOD(orderDetail);
		
	}

	@Override
	public void updateOId(OrderDetail orderDetail) {
		odMapper.updateOId(orderDetail);
		
	}

	@Override
	public void CountPrice(Orders orders) {
		odMapper.CountPrice(orders);
		
	}

	
	
	
}
