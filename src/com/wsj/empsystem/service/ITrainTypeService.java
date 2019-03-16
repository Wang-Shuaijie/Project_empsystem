package com.wsj.empsystem.service;

import java.util.HashMap;
import java.util.Map;

import com.wsj.empsystem.bean.TrainType;
import com.wsj.empsystem.exception.MyException;

public interface ITrainTypeService {
	//根据id查找培训类型
	TrainType findTrainTypeById(int id);
	//根据id删除培训类型
    void deleteTrainType(Integer id) throws MyException;
    //更新
    void updateTrainType(HashMap<String,Object> map) throws MyException;
    //新增
    void inserTrainType(HashMap<String,Object>map) throws MyException;
    //根据模糊查询关键字查找培训类型
	Map<String, Object> queryTrainType(String name);
}
