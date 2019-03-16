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
 * 创建Controller类
 * 	只要在地址栏中输入   http://ip:port/项目名/Adm 自动找到该Controller类
 * 									Adm/login 找到类中login方法去执行
 */
@Controller
@RequestMapping("/Admin")
public class AdmController {
	//注入service
	@Autowired
	private IAdminService adminService;
	@Autowired
	private IStaffService staffService;
	
	
	//Post方式提交的 url[/Adm/login] 自动找到该函数 去调用
	@RequestMapping(value="/login",method=RequestMethod.POST)
	//配置返回的信息 自动放入到 响应体中
	@ResponseBody
	public String login(HttpSession session,
			//required = true,这个是传参  当他为false 时  使用这个注解可以不传这个参数 , true时必须传
			@RequestParam(value="adminName",required=true)String adminName,
			@RequestParam(value="adminPassword",required=true)String adminPassword,
			@RequestParam(value="flag")int flag) throws Exception{
		// 获取从浏览器 发送过来的 登录信息，进行验证
		if(flag==1) {
			Administrator administrator=new Administrator();
			administrator.setAdmUserName(adminName);
			administrator.setAdmPassword(adminPassword);
			
			boolean b=adminService.checkAdm(administrator);
			if(b) {
				//记录当前用户的权限为2，表示是管理员，1代表普通用户
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
		//将用户名保存到session中，在index.jsp中可以获取
		session.setAttribute("username", adminName);
		return "index";
	}
	
	public String logOut(HttpSession session) {
		session.removeAttribute("username");
		//返回login.jsp
		return "login";
	}
	
}
