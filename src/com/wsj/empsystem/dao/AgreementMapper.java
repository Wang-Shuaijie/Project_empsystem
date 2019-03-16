package com.wsj.empsystem.dao;


import java.util.HashMap;
import java.util.List;

import com.wsj.empsystem.bean.Agreement;

public interface AgreementMapper {
    List<Agreement> queryAgr(HashMap<String,Object> map);
    Integer sum(); 
    //根据员工id查找合同信息
    List<Agreement> AgrCheckByStaffId(HashMap<String,Object> map);
    //根据合同id查找合同信息
    List<Agreement> AgrCheckByAgrId(HashMap<String,Object> map);
    //添加
    void insertAgr(HashMap<String,Object> map);
    //删除
    void deleteAgr(Integer id);
    //更改
    void updateAgr(HashMap<String,Object> map);
}
