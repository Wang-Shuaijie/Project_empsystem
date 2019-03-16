package com.wsj.empsystem.service;

import java.util.HashMap;
import java.util.Map;

import com.wsj.empsystem.bean.TrainType;
import com.wsj.empsystem.exception.MyException;

public interface ITrainTypeService {
	//����id������ѵ����
	TrainType findTrainTypeById(int id);
	//����idɾ����ѵ����
    void deleteTrainType(Integer id) throws MyException;
    //����
    void updateTrainType(HashMap<String,Object> map) throws MyException;
    //����
    void inserTrainType(HashMap<String,Object>map) throws MyException;
    //����ģ����ѯ�ؼ��ֲ�����ѵ����
	Map<String, Object> queryTrainType(String name);
}
