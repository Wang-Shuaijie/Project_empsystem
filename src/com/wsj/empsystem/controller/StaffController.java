package com.wsj.empsystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wsj.empsystem.bean.Department;
import com.wsj.empsystem.bean.Position;
import com.wsj.empsystem.bean.Staff;
import com.wsj.empsystem.service.IDepartmentService;
import com.wsj.empsystem.service.IPositionService;
import com.wsj.empsystem.service.IStaffService;

@Controller
@RequestMapping("Staff")
public class StaffController {
	@Autowired
	private IStaffService staffService;
	@Autowired
	private IDepartmentService deptService;
	@Autowired
	private IPositionService posiService;
	
	// 准备一个 Staff/page 对应的处理函数
	// 1.接收 浏览器发送 模糊查询的名称，2.去查找所有符合条件的 员工，得到所有员工对象
	// 3.将对象 返回给浏览器
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> page(@RequestParam(value="name")String name) throws Exception{
		Map<String, Object> map = staffService.findStaff(name);
		return (HashMap<String, Object>) map;
	}
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> insert(@RequestParam(value="name")String name,
		@RequestParam(value="sex")String sex,@RequestParam(value="degree")String degree,
		@RequestParam(value="dept_name")String dept_name,@RequestParam(value="pos_name")String pos_name,
		@RequestParam(value="state")String state,@RequestParam(value="username")String username,
		@RequestParam(value="password")String password ) throws Exception{
		HashMap<String, Object> map = new HashMap<>();
		Staff staff = new Staff();
		staff.setName(name);
		staff.setSex(sex);
		staff.setDegree(degree);
		staff.setState(state);
		staff.setUsername(username);
		staff.setPassword(password);
		Department department = deptService.findDepartmentByName(dept_name);
		staff.setDepartment(department);
		map.put("pos_name", pos_name);
		map.put("department", department);
		Position position = posiService.findPosByNameAndDept(map);
		staff.setPosition(position);
		staffService.insertStaff(staff);
		return map;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> update(
			@RequestParam(value="staffId")int staffId,@RequestParam(value="name")String name,
			@RequestParam(value="sex")String sex,@RequestParam(value="degree")String degree,
			@RequestParam(value="dept_name")String dept_name,@RequestParam(value="pos_name")String pos_name,
			@RequestParam(value="state")String state,@RequestParam(value="username")String username,
			@RequestParam(value="password")String password ) throws Exception{
		HashMap<String, Object> map = new HashMap<>();
		Staff staff = new Staff();
		staff.setId(staffId);
		staff.setName(name);
		staff.setSex(sex);
		staff.setDegree(degree);
		staff.setState(state);
		staff.setUsername(username);
		staff.setPassword(password);
		Department department = deptService.findDepartmentByName(dept_name);
		staff.setDepartment(department);
		map.put("pos_name", pos_name);
		map.put("department", department);
		Position position = posiService.findPosByNameAndDept(map);
		staff.setPosition(position);
		staffService.updateStaff(staff);
		return map;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> delete(@RequestParam(value="staffId")int staffId) throws Exception{
		HashMap< String, Object> map = new HashMap<>();
		staffService.deleteStaff(staffId);
		return map;
	}
	
	@RequestMapping(value="/findPosition",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> findPosition(@RequestParam(value="dept_name")String dept_name) throws Exception{
		HashMap< String, Object> map = new HashMap<>();
		Department department = deptService.findDepartmentByName(dept_name);
		List<Position> posis = posiService.findPosByDept(department);
		map.put("posis", posis);
		return map;
	}
}
