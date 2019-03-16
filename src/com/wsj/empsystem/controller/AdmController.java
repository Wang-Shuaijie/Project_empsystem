package com.wsj.empsystem.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wsj.empsystem.bean.Administrator;
import com.wsj.empsystem.bean.Staff;
import com.wsj.empsystem.exception.MyException;
import com.wsj.empsystem.service.IAdminService;
import com.wsj.empsystem.service.IStaffService;

/*
 * ����Controller��
 * 	ֻҪ�ڵ�ַ��������   http://ip:port/��Ŀ��/Adm �Զ��ҵ���Controller��
 * 									Adm/login �ҵ�����login����ȥִ��
 */
@Controller
@RequestMapping("/Admin")
public class AdmController {
	//ע��service
	@Autowired
	private IAdminService adminService;
	@Autowired
	private IStaffService staffService;
	
	
	//Post��ʽ�ύ�� url[/Adm/login] �Զ��ҵ��ú��� ȥ����
	@RequestMapping(value="/login",method=RequestMethod.POST)
	//���÷��ص���Ϣ �Զ����뵽 ��Ӧ����
	@ResponseBody
	public String login(HttpSession session,
			//required = true,����Ǵ���  ����Ϊfalse ʱ  ʹ�����ע����Բ���������� , trueʱ���봫
			@RequestParam(value="adminName",required=true)String adminName,
			@RequestParam(value="adminPassword",required=true)String adminPassword,
			@RequestParam(value="flag")int flag) throws Exception{
		// ��ȡ������� ���͹����� ��¼��Ϣ��������֤
		if(flag==1) {
			Administrator administrator=new Administrator();
			administrator.setAdmUserName(adminName);
			administrator.setAdmPassword(adminPassword);
			
			boolean b=adminService.checkAdm(administrator);
			if(b) {
				//��¼��ǰ�û���Ȩ��Ϊ2����ʾ�ǹ���Ա��1������ͨ�û�
				session.setAttribute("power", 2);
			}else {
				throw MyException.getException(400);
			}
		}else {
			Staff staff=new Staff();
			staff.setUsername(adminName);
			staff.setPassword(adminPassword);
			
			boolean b=staffService.checkStaff(staff);
			if(b) {
				session.setAttribute("power", 1);
			}else {
				throw MyException.getException(400);
			}
		}
		//���û������浽session�У���index.jsp�п��Ի�ȡ
		session.setAttribute("username", adminName);
		return "index";
	}
	
	public String logOut(HttpSession session) {
		session.removeAttribute("username");
		//����login.jsp
		return "login";
	}
	
}
