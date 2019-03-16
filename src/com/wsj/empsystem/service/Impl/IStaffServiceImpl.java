package com.wsj.empsystem.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsj.empsystem.bean.Department;
import com.wsj.empsystem.bean.Staff;
import com.wsj.empsystem.dao.DepartmentMapper;
import com.wsj.empsystem.dao.StaffMapper;
import com.wsj.empsystem.exception.MyException;
import com.wsj.empsystem.service.IStaffService;

@Service
public class IStaffServiceImpl implements IStaffService{
	@Autowired
	private StaffMapper staffMapper;
	@Autowired
	private DepartmentMapper deartmentMapper;
	@Override
	public Map<String, Object> findStaff(String name) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<>();
		map.put("name", name);
		List<Staff> staffs=staffMapper.queryAll((HashMap<String, Object>) map);
		List<Department> depts=deartmentMapper.findAllDep();
		map.put("depts", depts);
		map.put("staffs", staffs);
		return map;
	}

	@Override
	public Staff findStaffById(int id) {
		// TODO Auto-generated method stub
		Staff staff=staffMapper.findStaffById(id);
		return staff;
	}

	@Override
	public void deleteStaff(Integer id) {
		// TODO Auto-generated method stub
		staffMapper.deleteStaff(id);
	}

	@Override
	public void updateStaff(Staff staff) {
		// TODO Auto-generated method stub
		staffMapper.updateStaff(staff);
	}

	@Override
	public void insertStaff(Staff staff) throws MyException, Exception {
		// TODO Auto-generated method stub
		staffMapper.insertStaff(staff);
	}

	@Override
	public boolean checkStaff(Staff staff) {
		// TODO Auto-generated method stub
		List<Staff> list=staffMapper.checkUser(staff);
		if(list.size()>0) {
			for(int i=0;i<list.size();i++) {
				if(list.get(i).getUsername().equals(staff.getUsername())
						&&list.get(i).getPassword().equals(staff.getPassword())) {
					return true;
					
				}
			}
		}
		return false;
	}
	
}
