package com.wsj.empsystem.bean;

/**
 * 员工信息类
 * 
 * @author WangShuaiJie
 *
 */
public class Staff {
	// 员工id
	private int id;
	// 员工姓名
	private String name;
	// 员工性别
	private String sex;
	// 学历
	private String degree;
	// 部门
	private Department department;
	// 职位
	private Position position;
	// 状态，分为在职和离职两种
	private String state;
	// 用户名
	private String username;
	// 密码
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
