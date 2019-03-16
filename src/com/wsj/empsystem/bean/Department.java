package com.wsj.empsystem.bean;

/**
 * 员工部门类
 * 
 * @author WangShuaiJie
 *
 */
public class Department {
	// 部门id
	private Integer dept_id;
	// 部门名字
	private String dept_name;

	public Department() {

	}

	public Integer getDept_id() {
		return dept_id;
	}

	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	@Override
	public String toString() {
		return "Department [dept_id=" + dept_id + ", dept_name=" + dept_name + "]";
	}

}
