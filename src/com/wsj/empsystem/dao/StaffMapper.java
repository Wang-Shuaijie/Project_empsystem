package com.wsj.empsystem.dao;


import java.util.HashMap;
import java.util.List;

import com.wsj.empsystem.bean.Staff;

public interface StaffMapper{
	//模糊查询
    List<Staff> queryAll(HashMap<String,Object> map);
    //统计员工总数
    Integer sum() ;
    //删除
    void deleteStaff(Integer id);
    //更新
    void updateStaff(Staff staff);
    //添加
    void insertStaff(Staff staff);
    //判断是否存在
    List<Staff> checkUser(Staff staff);
    //判断是否是管理员
    List<Staff> AgrCheck(HashMap<String,Object> map);
    //根据姓名查找
    String selectName(String username);
    //根据id查找
    Staff findStaffById(Integer id);
}
