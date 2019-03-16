package com.wsj.empsystem.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsj.empsystem.bean.Train;
import com.wsj.empsystem.dao.TrainMapper;
import com.wsj.empsystem.exception.MyException;
import com.wsj.empsystem.service.ITrainService;

@Service
public class ITrainServiceImpl implements ITrainService{
	@Autowired
	private TrainMapper trainMapper;

	@Override
	public void deleteTrain(Integer id) {
		// TODO Auto-generated method stub
		trainMapper.deleteTrain(id);
	}

	@Override
	public void updateTrain(HashMap<String, Object> map) throws MyException {
		// TODO Auto-generated method stub
		trainMapper.updateTrain(map);
	}

	@Override
	public void insertTrain(HashMap<String, Object> map) throws MyException {
		// TODO Auto-generated method stub
		trainMapper.insertTrain(map);
	}

	@Override
	public Map<String, Object> findTrain(String name) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map=new HashMap<>();
		map.put("name", name);
		List<Train> list=trainMapper.queryTrain(map);
		map.put("trains",list);
		return map;
		
	}

}
