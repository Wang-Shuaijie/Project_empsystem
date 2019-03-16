package com.wsj.empsystem.service.Impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsj.empsystem.bean.Department;
import com.wsj.empsystem.bean.Position;
import com.wsj.empsystem.dao.PositionMapper;
import com.wsj.empsystem.service.IPositionService;

@Service
public class IPositionServiceImpl implements IPositionService{
	@Autowired
	private PositionMapper positionMapper;
	
	@Override
	public List<Position> findPosByDept(Department department) {
		// TODO Auto-generated method stub
		List<Position> list=positionMapper.findPosByDept(department);
		return list;
	}

	@Override
	public Position findPosById(int id) {
		// TODO Auto-generated method stub
		Position position=positionMapper.findPosById(id);
		return position;
	}

	@Override
	public Position findPosByNameAndDept(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		Position position=positionMapper.findPosByNameAndDept(map);
		return position;
	}

}
