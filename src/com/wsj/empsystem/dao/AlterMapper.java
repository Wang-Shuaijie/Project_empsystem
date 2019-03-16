package com.wsj.empsystem.dao;


import java.util.HashMap;
import java.util.List;

import com.wsj.empsystem.bean.Alter;

public interface AlterMapper {
	//根据模糊查询关键字查找出差信息
    List<Alter> queryAlter(HashMap<String,Object> map);
    //统计出差数量
    Integer sum();
    //删除出差信息
    void deleteAlter(Integer id);
    //更新出差信息
    void updateAlter(HashMap<String,Object> map);
    //添加
    void insertAlter(HashMap<String,Object> map);
}
