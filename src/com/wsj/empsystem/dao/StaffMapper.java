package com.wsj.empsystem.dao;


import java.util.HashMap;
import java.util.List;

import com.wsj.empsystem.bean.Staff;

public interface StaffMapper{
	//ģ����ѯ
    List<Staff> queryAll(HashMap<String,Object> map);
    //ͳ��Ա������
    Integer sum() ;
    //ɾ��
    void deleteStaff(Integer id);
    //����
    void updateStaff(Staff staff);
    //���
    void insertStaff(Staff staff);
    //�ж��Ƿ����
    List<Staff> checkUser(Staff staff);
    //�ж��Ƿ��ǹ���Ա
    List<Staff> AgrCheck(HashMap<String,Object> map);
    //������������
    String selectName(String username);
    //����id����
    Staff findStaffById(Integer id);
}
