package com.wsj.empsystem.bean;
/**
 * ְλ��
 * @author WangShuaiJie
 *
 */
public class Position {
	private int pos_id;
	private String pos_name;//ְλ����
	private Department department;//ְλ����
	
	public Position() {
		// TODO Auto-generated constructor stub
	}

	public int getPos_id() {
		return pos_id;
	}

	public void setPos_id(int pos_id) {
		this.pos_id = pos_id;
	}

	public String getPos_name() {
		return pos_name;
	}

	public void setPos_name(String pos_name) {
		this.pos_name = pos_name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Position [pos_id=" + pos_id + ", pos_name=" + pos_name + ", department=" + department + "]";
	}
	
}
