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

import com.wsj.empsystem.bean.Staff;
import com.wsj.empsystem.bean.Train;
import com.wsj.empsystem.bean.TrainType;
import com.wsj.empsystem.service.IStaffService;
import com.wsj.empsystem.service.ITrainService;
import com.wsj.empsystem.service.ITrainTypeService;

@Controller
@RequestMapping("Train")
public class TrainController {
	@Autowired
	private ITrainService trainService;
	@Autowired
	private IStaffService staffService;
	@Autowired
	private ITrainTypeService trainTypeService;
	
	@RequestMapping(value="/page",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> page(@RequestParam(value="name")String name)throws Exception{
		Map<String, Object> map = trainService.findTrain(name);
		return (HashMap<String, Object>) map;
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> insert(@RequestParam(value="train_experience")String train_expense,
			@RequestParam(value="train_btime")String train_btime,
			@RequestParam(value="train_etime")String train_etime,
			@RequestParam(value="p_id")int p_id,
			@RequestParam(value="type_code")int type_code) throws Exception{
		HashMap<String, Object> map = new HashMap<>();
		Staff staff = staffService.findStaffById(p_id);
		if(staff==null){
			map.put("status", "error");
			map.put("msg", "员工编号不存在");
			return map;
		}
		TrainType type = trainTypeService.findTrainTypeById(type_code);
		if(type==null){
			map.put("status", "error");
			map.put("msg", "培训类型不存在");
			return map;
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy MM dd");
		Date d1 = new Date(format.parse(train_btime).getTime());
		Date d2 = new Date(format.parse(train_etime).getTime());
		Train train = new Train();
		train.setStaff(staff);
		train.setTrainType(type);
		train.setTrain_expense(train_expense);
		train.setTrain_btime(d1);
		train.setTrain_etime(d2);
		map.put("train", train);
		trainService.insertTrain(map);
		return map;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> update(@RequestParam(value="train_experience")String train_experience,
			@RequestParam(value="train_btime")String train_btime,
			@RequestParam(value="train_etime")String train_etime,
			@RequestParam(value="train_id")int train_id) throws Exception{
		HashMap<String, Object> map = new HashMap<>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy MM dd");
		Date d1 = new Date(format.parse(train_btime).getTime());
		Date d2 = new Date(format.parse(train_etime).getTime());
		Train train = new Train();
		train.setTrain_id(train_id);
		train.setTrain_expense(train_experience);
		train.setTrain_btime(d1);
		train.setTrain_etime(d2);
		map.put("train", train);
		trainService.updateTrain(map);
		return map;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> delete(@RequestParam(value="train_id")int train_id) throws Exception{
		HashMap<String, Object> map = new HashMap<>();
		trainService.deleteTrain(train_id);
		return map;
	}
}
