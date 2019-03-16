package com.wsj.empsystem.dao;

import java.util.HashMap;
import java.util.List;

import com.wsj.empsystem.bean.Department;
import com.wsj.empsystem.bean.Position;

public interface PositionMapper {
	// 查找指定部门下的所有职位信息
	List<Position> findPosByDept(Department department);
	// 根据id查找职位信息
	Position findPosById(int id);
	// 根据部门和职位名查找职位信息
	Position findPosByNameAndDept(HashMap<String, Object> map);
}
