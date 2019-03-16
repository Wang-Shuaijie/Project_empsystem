package com.wsj.empsystem.dao;


import java.util.HashMap;
import java.util.List;

import com.wsj.empsystem.bean.Agreement;

public interface AgreementMapper {
    List<Agreement> queryAgr(HashMap<String,Object> map);
    Integer sum(); 
    //����Ա��id���Һ�ͬ��Ϣ
    List<Agreement> AgrCheckByStaffId(HashMap<String,Object> map);
    //���ݺ�ͬid���Һ�ͬ��Ϣ
    List<Agreement> AgrCheckByAgrId(HashMap<String,Object> map);
    //���
    void insertAgr(HashMap<String,Object> map);
    //ɾ��
    void deleteAgr(Integer id);
    //����
    void updateAgr(HashMap<String,Object> map);
}
