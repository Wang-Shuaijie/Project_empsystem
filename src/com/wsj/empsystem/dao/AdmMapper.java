package com.wsj.empsystem.dao;

import com.wsj.empsystem.bean.Administrator;

public interface AdmMapper {
	//查找管理员
    Administrator queryAdm(Administrator administrator);
    //添加
    void insertAdm(Administrator administrator);
    //删除
    void deleteAdm(String admin_username);
}
