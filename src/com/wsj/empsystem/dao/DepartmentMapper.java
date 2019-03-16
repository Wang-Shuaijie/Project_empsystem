package com.wsj.empsystem.dao;

import java.util.List;

import com.wsj.empsystem.bean.Department;

public interface DepartmentMapper {
	//��ѯ���в���
	List<Department> findAllDep();
	//���ݲ��������Ҳ�����Ϣ
	Department findDepByName(String name) ;
	//���ݲ���id���Ҳ�����Ϣ
	Department findDepById(int id) ;
}
