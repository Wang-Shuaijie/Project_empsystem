package com.wsj.empsystem.service;

import com.wsj.empsystem.bean.Administrator;

public interface IAdminService {
	//�ж��Ƿ��¼
	boolean checkAdm(Administrator administrator);
	//ע��
	void insert(Administrator administrator);
	//�ж��Ƿ����
	boolean exist(Administrator administrator);
	//ɾ���û�
	void delete(Administrator administrator);
}
