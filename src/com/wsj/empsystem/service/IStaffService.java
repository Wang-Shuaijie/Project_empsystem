package com.wsj.empsystem.service;

import java.util.Map;

import com.wsj.empsystem.bean.Staff;
import com.wsj.empsystem.exception.MyException;

public interface IStaffService {
	//根据模糊查询关键字查找员工信息(查询所有员工信息)
	public Map<String,Object> findStaff(String name);
	//根据员工id查找员工信息
  	public Staff findStaffById(int id);
	//根据员工id删除员工信息
    public void deleteStaff(Integer id);
    //更新员工信息
    public void updateStaff(Staff staff);
    //新增员工信息
    public void insertStaff(Staff staff) throws MyException, Exception;
    //检验员工的用户名密码
    boolean checkStaff(Staff staff);
  
}
