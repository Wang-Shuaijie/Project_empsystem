package com.wsj.empsystem.service;

import java.util.List;

import com.wsj.empsystem.bean.Department;

public interface IDepartmentService {
	//����ȫ������
	List<Department> findAllDepartment();
	//����id����
	Department findDepartmentById(int id);
	//������������
	Department findDepartmentByName(String name);	
}
