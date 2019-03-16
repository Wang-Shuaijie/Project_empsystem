package com.wsj.empsystem.dao;

import java.util.HashMap;
import java.util.List;

import com.wsj.empsystem.bean.Department;
import com.wsj.empsystem.bean.Position;

public interface PositionMapper {
	// ����ָ�������µ�����ְλ��Ϣ
	List<Position> findPosByDept(Department department);
	// ����id����ְλ��Ϣ
	Position findPosById(int id);
	// ���ݲ��ź�ְλ������ְλ��Ϣ
	Position findPosByNameAndDept(HashMap<String, Object> map);
}
