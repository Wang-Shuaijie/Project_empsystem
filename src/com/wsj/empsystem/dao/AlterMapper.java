package com.wsj.empsystem.dao;


import java.util.HashMap;
import java.util.List;

import com.wsj.empsystem.bean.Alter;

public interface AlterMapper {
	//����ģ����ѯ�ؼ��ֲ��ҳ�����Ϣ
    List<Alter> queryAlter(HashMap<String,Object> map);
    //ͳ�Ƴ�������
    Integer sum();
    //ɾ��������Ϣ
    void deleteAlter(Integer id);
    //���³�����Ϣ
    void updateAlter(HashMap<String,Object> map);
    //���
    void insertAlter(HashMap<String,Object> map);
}
