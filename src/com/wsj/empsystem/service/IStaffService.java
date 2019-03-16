package com.wsj.empsystem.service;

import java.util.Map;

import com.wsj.empsystem.bean.Staff;
import com.wsj.empsystem.exception.MyException;

public interface IStaffService {
	//����ģ����ѯ�ؼ��ֲ���Ա����Ϣ(��ѯ����Ա����Ϣ)
	public Map<String,Object> findStaff(String name);
	//����Ա��id����Ա����Ϣ
  	public Staff findStaffById(int id);
	//����Ա��idɾ��Ա����Ϣ
    public void deleteStaff(Integer id);
    //����Ա����Ϣ
    public void updateStaff(Staff staff);
    //����Ա����Ϣ
    public void insertStaff(Staff staff) throws MyException, Exception;
    //����Ա�����û�������
    boolean checkStaff(Staff staff);
  
}
