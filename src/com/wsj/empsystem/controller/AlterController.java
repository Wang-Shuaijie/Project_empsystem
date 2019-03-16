package com.wsj.empsystem.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wsj.empsystem.bean.Alter;
import com.wsj.empsystem.bean.Staff;
import com.wsj.empsystem.service.IAlterService;
import com.wsj.empsystem.service.IStaffService;

@Controller
@RequestMapping("Alter")
public class AlterController {
	@Autowired
	private IAlterService alterService;
	@Autowired
	private IStaffService staffService;
	
	@RequestMapping(value="/page",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> page(@RequestParam(value="name")String name)throws Exception{
		Map<String, Object> map=alterService.findAlter(name);
		return (HashMap<String, Object>) map;
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> insert(@RequestParam(value="alter_content")String alter_content,
			@RequestParam(value="alter_btime")String alter_btime,
			@RequestParam(value="alter_etime")String alter_etime,
			@RequestParam(value="p_id")int p_id ) throws Exception{
		HashMap< String, Object> map = new HashMap<>();	
		Staff staff = staffService.findStaffById(p_id);	
		System.out.println(staff);
		Alter alter = new Alter();
		alter.setAlter_content(alter_content);
		//将字符串日期格式转换为日期对象
		SimpleDateFormat format = new SimpleDateFormat("yyyy MM dd");
		Date btime = new Date(format.parse(alter_btime).getTime());
		Date etime = new Date(format.parse(alter_etime).getTime());
		alter.setAlter_btime(btime);
		alter.setAlter_etime(etime);
		alter.setStaff(staff);
		map.put("alter", alter);
		alterService.insertAlter(map);
		return map;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> update(@RequestParam(value="alter_content")String alter_content,
			@RequestParam(value="alter_btime")String alter_btime,
			@RequestParam(value="alter_etime")String alter_etime,
			@RequestParam(value="alter_id")int alter_id) throws Exception{
		HashMap< String, Object> map = new HashMap<>();	
		Alter alter = new Alter();
		alter.setAlterId(alter_id);
		alter.setAlter_content(alter_content);
		//将字符串日期格式转换为日期对象
		SimpleDateFormat format = new SimpleDateFormat("yyyy MM dd");
		Date btime = new Date(format.parse(alter_btime).getTime());
		Date etime = new Date(format.parse(alter_etime).getTime());
		alter.setAlter_btime(btime);
		alter.setAlter_etime(etime);
		map.put("alter", alter);
		alterService.updateAlter(map);
		return map;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> delete(@RequestParam(value="alter_id")int alter_id) throws Exception{
		HashMap< String, Object> map = new HashMap<>();	
		alterService.deleteAlter(alter_id);
		return map;
	}
	
}
