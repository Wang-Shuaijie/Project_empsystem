package com.wsj.empsystem.bean;

/**
 * Ա����Ϣ��
 * 
 * @author WangShuaiJie
 *
 */
public class Staff {
	// Ա��id
	private int id;
	// Ա������
	private String name;
	// Ա���Ա�
	private String sex;
	// ѧ��
	private String degree;
	// ����
	private Department department;
	// ְλ
	private Position position;
	// ״̬����Ϊ��ְ����ְ����
	private String state;
	// �û���
	private String username;
	// ����
	private String password;
	
	public Staff() {
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
