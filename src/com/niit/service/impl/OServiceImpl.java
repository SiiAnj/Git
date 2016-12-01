package com.niit.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mapper.OMapper;
import com.niit.model.Orders;
import com.niit.page.Page;
import com.niit.service.OService;


@Service // 相当于是将此类交给Spring管理  相当于在applicationContext.xml中定义一个 bean
@Transactional // 告诉Spring 该类中所有事物 都有Spring配置文件中 事务管理器去管理
public class OServiceImpl implements OService {

	// 注入mapper Spring帮我们调用mapper中的方法
	@Resource //资源 byName注入
	private OMapper oMapper;

	@Override
	public List<Orders> getAll(Page page) {
		return oMapper.getAll(page);
	}
	
	@Override
	public int getTotalCount() {
		return oMapper.getTotalCount();
	}

	@Override
	public void unsubscribeO(Orders orders) {
		oMapper.unsubscribeO(orders);
	}

	@Override
	public void unsubscribeDT(){
		oMapper.unsubscribeDT();
	}

	@Override
	public void bill(Orders orders) {
		oMapper.bill(orders);
	}
}
