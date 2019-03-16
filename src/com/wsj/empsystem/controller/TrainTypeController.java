package com.wsj.empsystem.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wsj.empsystem.bean.TrainType;
import com.wsj.empsystem.service.ITrainTypeService;

@Controller
@RequestMapping("TrainType")
public class TrainTypeController {
	@Autowired
	private ITrainTypeService trainTypeService;
	
	
	
	@RequestMapping(value="/page",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> page(@RequestParam(value="name")String name)throws Exception{
		Map<String, Object> map = trainTypeService.queryTrainType(name);
		
		return (HashMap<String, Object>) map;
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> insert(@RequestParam(value="type_name")String type_name,
			@RequestParam(value="type_info")String type_info)throws Exception{
		HashMap<String, Object> map = new HashMap<>();
		TrainType type = new TrainType();
		type.setType_name(type_name);
		type.setType_info(type_info);
		map.put("type", type);
		trainTypeService.inserTrainType(map);
		
		return map;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> update(@RequestParam(value="type_name")String type_name,
			@RequestParam(value="type_info")String type_info,
			@RequestParam(value="type_code")int type_code)throws Exception{
		HashMap<String, Object> map = new HashMap<>();
		TrainType type = new TrainType();
		type.setType_name(type_name);
		type.setType_info(type_info);
		type.setType_code(type_code);
		map.put("type", type);
		trainTypeService.updateTrainType(map);
		return map;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> delete(@RequestParam(value="type_code")int type_code)throws Exception{
		HashMap<String, Object> map = new HashMap<>();
		trainTypeService.deleteTrainType(type_code);
		
		return map;
	}
}
