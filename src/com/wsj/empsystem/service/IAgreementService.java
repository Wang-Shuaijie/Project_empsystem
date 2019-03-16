package com.wsj.empsystem.service;

import java.util.HashMap;
import java.util.Map;

import com.wsj.empsystem.exception.MyException;

public interface IAgreementService {
	//���ݺ�ͬ���ɾ����ͬ��Ϣ
    void deleteAgr(Integer id);
    //���º�ͬ��Ϣ
    void updateAgr(HashMap<String,Object> map);
    //����Ա��id���Ա���Ƿ��Ѿ�ǩ������ͬ
    boolean AgrCheckByStaffId(HashMap<String,Object> map) throws Exception;
    //���ݺ�ͬid���Ա���Ƿ��Ѿ�ǩ������ͬ
    boolean AgrCheckByAgrId(HashMap<String,Object> map) throws Exception;
    //������ͬ��Ϣ
    void  insertAgr(HashMap<String,Object> map) throws MyException;
    //����ģ����ѯ�ؼ��ֲ��Һ�ͬ��Ϣ
	Map<String, Object> findAgreement(String name);
}
