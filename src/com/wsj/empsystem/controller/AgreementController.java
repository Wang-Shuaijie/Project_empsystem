package com.wsj.empsystem.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wsj.empsystem.bean.Agreement;
import com.wsj.empsystem.bean.Staff;
import com.wsj.empsystem.service.IAgreementService;
import com.wsj.empsystem.service.IStaffService;

@Controller
@RequestMapping("Agreement")
public class AgreementController {
	@Autowired
	private IStaffService staffService;
	@Autowired
	private IAgreementService agreementService;
	
	@RequestMapping(value="/page",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> page(@RequestParam(value="name")String name) throws Exception{
		Map<String, Object> map = agreementService.findAgreement(name);
		return (HashMap<String, Object>) map;
	}
	
	public HashMap<String, Object> insert(@RequestParam(value="file")MultipartFile file,
			@RequestParam(value="agreement_btime")String agreement_btime,
			@RequestParam(value="p_id")int p_id,
			HttpServletRequest request) throws Exception{
		HashMap<String, Object> map = new HashMap<>();
		map.put("p_id", p_id);
		//获取上传文件名
		String filename = file.getOriginalFilename();
		SimpleDateFormat format = new SimpleDateFormat("yyyy MM dd");
		Date date = new Date(format.parse(agreement_btime).getTime());
		Agreement agreement = new Agreement();
		agreement.setAgreement_content(filename);
		agreement.setAgreement_btime(date);
		//查看是否存在该id的员工
		Staff staff = staffService.findStaffById(p_id);
		if(staff!=null){
			//判断该员工是否已经签订合同
			agreement.setStaff(staff);
			map.put("agreement", agreement);
			if(!agreementService.AgrCheckByStaffId(map)){
				//获取文件要保存的路径
				String realPath = request.getServletContext().getRealPath("/")+"file\\"+filename;
				File newFile = new File(realPath);
				//如果父母录不存在，就创建
				if(!newFile.getParentFile().exists()){
					newFile.getParentFile().mkdirs();
				}
				//文件转存
				file.transferTo(newFile);
				agreementService.insertAgr(map);
			}else{
				map.put("status", "error");
				map.put("msg", "该员工已签订合同");
				return map;
			}
		}else{
			map.put("status", "error");
			map.put("msg", "该员工编号不存在");
			return map;
		}
		map.put("status", "ok");
		return map;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> delete(@RequestParam(value="id")Integer id)throws Exception{
		HashMap<String, Object> map=new HashMap<>();
		agreementService.deleteAgr(id);
		return map;
	}
	
}
