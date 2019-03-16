package com.wsj.empsystem.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsj.empsystem.bean.TrainType;
import com.wsj.empsystem.dao.TrainTypeMapper;
import com.wsj.empsystem.exception.MyException;
import com.wsj.empsystem.service.ITrainService;
import com.wsj.empsystem.service.ITrainTypeService;

@Service
public class ITrainTypeServiceImpl implements ITrainTypeService{
	@Autowired
	private TrainTypeMapper trainTypeMapper;
	

	@Override
	public TrainType findTrainTypeById(int id) {
		// TODO Auto-generated method stub
		TrainType trainType=trainTypeMapper.findTrainTypeById(id);
		return trainType;
	}

	@Override
	public void deleteTrainType(Integer id) throws MyException {
		// TODO Auto-generated method stub
		trainTypeMapper.deleteTrainType(id);
	}

	@Override
	public void updateTrainType(HashMap<String, Object> map) throws MyException {
		// TODO Auto-generated method stub
		trainTypeMapper.updateTrainType(map);
	}

	@Override
	public void inserTrainType(HashMap<String, Object> map) throws MyException {
		// TODO Auto-generated method stub
		trainTypeMapper.insertTrainType(map);
	}

	@Override
	public Map<String, Object> queryTrainType(String name) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", name);
		List<TrainType> types = trainTypeMapper.queryTrainType(map);
		map.put("types", types);
		return map;
	}

}
