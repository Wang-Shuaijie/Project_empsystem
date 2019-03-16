package com.wsj.empsystem.dao;

import java.util.List;

import com.wsj.empsystem.bean.Department;

public interface DepartmentMapper {
	//查询所有部门
	List<Department> findAllDep();
	//根据部门名查找部门信息
	Department findDepByName(String name) ;
	//根据部门id查找部门信息
	Department findDepById(int id) ;
}
