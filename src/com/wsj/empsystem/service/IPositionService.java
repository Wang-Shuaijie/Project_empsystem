package com.wsj.empsystem.service;

import java.util.HashMap;
import java.util.List;

import com.wsj.empsystem.bean.Department;
import com.wsj.empsystem.bean.Position;

public interface IPositionService {
	List<Position> findPosByDept(Department department) ;
	Position findPosById(int id) ;
	Position findPosByNameAndDept(HashMap<String, Object> map);
}
