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
		//��ȡ�ϴ��ļ���
		String filename = file.getOriginalFilename();
		SimpleDateFormat format = new SimpleDateFormat("yyyy MM dd");
		Date date = new Date(format.parse(agreement_btime).getTime());
		Agreement agreement = new Agreement();
		agreement.setAgreement_content(filename);
		agreement.setAgreement_btime(date);
		//�鿴�Ƿ���ڸ�id��Ա��
		Staff staff = staffService.findStaffById(p_id);
		if(staff!=null){
			//�жϸ�Ա���Ƿ��Ѿ�ǩ����ͬ
			agreement.setStaff(staff);
			map.put("agreement", agreement);
			if(!agreementService.AgrCheckByStaffId(map)){
				//��ȡ�ļ�Ҫ�����·��
				String realPath = request.getServletContext().getRealPath("/")+"file\\"+filename;
				File newFile = new File(realPath);
				//�����ĸ¼�����ڣ��ʹ���
				if(!newFile.getParentFile().exists()){
					newFile.getParentFile().mkdirs();
				}
				//�ļ�ת��
				file.transferTo(newFile);
				agreementService.insertAgr(map);
			}else{
				map.put("status", "error");
				map.put("msg", "��Ա����ǩ����ͬ");
				return map;
			}
		}else{
			map.put("status", "error");
			map.put("msg", "��Ա����Ų�����");
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
