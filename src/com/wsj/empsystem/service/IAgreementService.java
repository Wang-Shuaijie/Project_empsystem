package com.wsj.empsystem.service;

import java.util.HashMap;
import java.util.Map;

import com.wsj.empsystem.exception.MyException;

public interface IAgreementService {
	//根据合同编号删除合同信息
    void deleteAgr(Integer id);
    //跟新合同信息
    void updateAgr(HashMap<String,Object> map);
    //根据员工id检查员工是否已经签订过合同
    boolean AgrCheckByStaffId(HashMap<String,Object> map) throws Exception;
    //根据合同id检查员工是否已经签订过合同
    boolean AgrCheckByAgrId(HashMap<String,Object> map) throws Exception;
    //新增合同信息
    void  insertAgr(HashMap<String,Object> map) throws MyException;
    //根据模糊查询关键字查找合同信息
	Map<String, Object> findAgreement(String name);
}
