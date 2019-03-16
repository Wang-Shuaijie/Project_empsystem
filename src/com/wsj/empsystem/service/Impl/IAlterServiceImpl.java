package com.wsj.empsystem.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsj.empsystem.bean.Alter;
import com.wsj.empsystem.dao.AlterMapper;
import com.wsj.empsystem.service.IAlterService;

@Service
public class IAlterServiceImpl implements IAlterService{
	@Autowired
	private AlterMapper alterMapper;
	@Override
	public void deleteAlter(Integer id) {
		// TODO Auto-generated method stub
		alterMapper.deleteAlter(id);
	}

	@Override
	public void updateAlter(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		alterMapper.updateAlter(map);
	}

	@Override
	public void insertAlter(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		alterMapper.insertAlter(map);
	}

	@Override
	public Map<String, Object> findAlter(String name) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map=new HashMap<>();
		map.put("name", name);
		List<Alter> list=alterMapper.queryAlter(map);
		map.put("alters", list);
		return map;
	}

}
