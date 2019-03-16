package com.wsj.empsystem.service;

import java.util.List;

import com.wsj.empsystem.bean.Department;

public interface IDepartmentService {
	//查找全部部门
	List<Department> findAllDepartment();
	//根据id查找
	Department findDepartmentById(int id);
	//根据姓名查找
	Department findDepartmentByName(String name);	
}
