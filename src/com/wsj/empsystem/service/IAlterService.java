package com.wsj.empsystem.service;

import java.util.HashMap;
import java.util.Map;

public interface IAlterService {
	//ɾ��������Ϣ
    void deleteAlter(Integer id);
    //���³�����Ϣ
    void updateAlter(HashMap<String,Object> map);
    //����������Ϣ
    void insertAlter(HashMap<String,Object> map);
    //����ģ����ѯ�ؼ��ֲ��ҳ�����Ϣ
	Map<String, Object> findAlter(String name);
}
