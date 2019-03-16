package com.wsj.empsystem.service;

import java.util.HashMap;
import java.util.Map;

import com.wsj.empsystem.exception.MyException;

public interface ITrainService {
	void deleteTrain(Integer id);

	void updateTrain(HashMap<String, Object> map) throws MyException;

	void insertTrain(HashMap<String, Object> map) throws MyException;

	Map<String, Object> findTrain(String name);
}
