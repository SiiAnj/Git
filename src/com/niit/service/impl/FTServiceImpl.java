package com.niit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mapper.DTMapper;
import com.niit.mapper.FTMapper;
import com.niit.model.DinnerTable;
import com.niit.model.FoodType;
import com.niit.page.Page;
import com.niit.service.DTService;
import com.niit.service.FTService;


@Service // 相当于是将此类交给Spring管理  相当于在applicationContext.xml中定义一个 bean
@Transactional // 告诉Spring 该类中所有事物 都有Spring配置文件中 事务管理器去管理
public class FTServiceImpl implements FTService {

	// 注入mapper Spring帮我们调用mapper中的方法
	@Resource //资源 byName注入
	private FTMapper ftMapper;

	@Override
	public List<FoodType> getAll(Page page) {
		return ftMapper.getAll(page);
	}
	
	@Override
	public int getTotalCount() {
		
		return ftMapper.getTotalCount();
	}

	@Override
	public void save(FoodType foodType) {
		ftMapper.save(foodType);
	}

	@Override
	public FoodType findById(int id) {
		return ftMapper.findById(id);
	}

	@Override
	public void update(FoodType foodType) {
		ftMapper.update(foodType);
	}

	@Override
	public boolean delete(int id) {
		return ftMapper.delete(id);
	}

	
	
	
}
