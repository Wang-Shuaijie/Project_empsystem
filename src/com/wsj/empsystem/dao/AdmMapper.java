package com.wsj.empsystem.dao;

import com.wsj.empsystem.bean.Administrator;

public interface AdmMapper {
	//���ҹ���Ա
    Administrator queryAdm(Administrator administrator);
    //���
    void insertAdm(Administrator administrator);
    //ɾ��
    void deleteAdm(String admin_username);
}
