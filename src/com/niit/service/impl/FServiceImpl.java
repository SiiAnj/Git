package com.niit.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mapper.FMapper;
import com.niit.model.Food;
import com.niit.page.Page;
import com.niit.service.FService;


@Service // 相当于是将此类交给Spring管理  相当于在applicationContext.xml中定义一个 bean
@Transactional // 告诉Spring 该类中所有事物 都有Spring配置文件中 事务管理器去管理
public class FServiceImpl implements FService {

	// 注入mapper Spring帮我们调用mapper中的方法
	@Resource //资源 byName注入
	private FMapper fMapper;

	@Override
	public List<Food> getAll(Page page) {
		return fMapper.getAll(page);
	}
	
	@Override
	public int getTotalCount() {
		return fMapper.getTotalCount();
	}

	@Override
	public void save(Food food) {
		fMapper.save(food);
	}

	@Override
	public void getLast(int id) {
		fMapper.getLast(id);
	}
	
	@Override
	public Food findById(int id) {
		return fMapper.findById(id);
	}

	@Override
	public void update(Food food) {
		fMapper.update(food);
	}

	@Override
	public boolean delete(int id) {
		return fMapper.delete(id);
	}

	@Override
	public void CloseForeignKey() {
		fMapper.CloseForeignKey();
	}

	@Override
	public void OpenForeignKey() {
		fMapper.OpenForeignKey();
	}

	@Override
	public void upImg(Food food) {
		fMapper.upImg(food);
		
	}

	@Override
	public Food findByName(String foodName) {
		return fMapper.findByName(foodName);
	}
}
