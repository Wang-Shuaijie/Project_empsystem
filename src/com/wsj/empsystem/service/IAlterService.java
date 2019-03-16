package com.wsj.empsystem.service;

import java.util.HashMap;
import java.util.Map;

public interface IAlterService {
	//删除出差信息
    void deleteAlter(Integer id);
    //更新出差信息
    void updateAlter(HashMap<String,Object> map);
    //新增出差信息
    void insertAlter(HashMap<String,Object> map);
    //根据模糊查询关键字查找出差信息
	Map<String, Object> findAlter(String name);
}
