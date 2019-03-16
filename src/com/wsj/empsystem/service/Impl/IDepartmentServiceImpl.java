package com.wsj.empsystem.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsj.empsystem.bean.Department;
import com.wsj.empsystem.dao.DepartmentMapper;
import com.wsj.empsystem.service.IDepartmentService;

@Service
public class IDepartmentServiceImpl implements IDepartmentService{
	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Override
	public List<Department> findAllDepartment() {
		// TODO Auto-generated method stub
		List<Department> list=departmentMapper.findAllDep();
		return list;
	}

	@Override
	public Department findDepartmentById(int id) {
		// TODO Auto-generated method stub
		Department department=departmentMapper.findDepById(id);
		return department;
	}

	@Override
	public Department findDepartmentByName(String name) {
		// TODO Auto-generated method stub
		Department department=departmentMapper.findDepByName(name);
		return department;
	}

}
