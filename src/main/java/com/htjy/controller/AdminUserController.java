package com.htjy.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.htjy.entity.AdminUserInfo;
import com.htjy.service.AdminUserService;
import com.htjy.util.HttpRequestResultData;

/**
 * 
 * @author wcy
 *
 */
@Controller
@RequestMapping("/adminUser")
public class AdminUserController {

	@Autowired
	private AdminUserService adminUserService;

	@ResponseBody
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public HttpRequestResultData<AdminUserInfo> login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {

		HttpRequestResultData<AdminUserInfo> result = new HttpRequestResultData<>();
		try {
			AdminUserInfo adminUser = adminUserService.login(username, password);
			if (adminUser == null) {
				result.setResult(false);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("admin", adminUser);
				adminUser.setPassword(password);
				result.setData(adminUser);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setResult(false);
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "logout.do", method = { RequestMethod.POST, RequestMethod.GET })
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("admin");
		response.sendRedirect("../admin/login.html");
	}

	@ResponseBody
	@RequestMapping(value = "getAdminUserName.do", method = { RequestMethod.POST, RequestMethod.GET },produces="text/html;charset=UTF-8")
	public String getAdminUserName(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		AdminUserInfo user = (AdminUserInfo) session.getAttribute("admin");
		JSONObject o = new JSONObject();
		if (user == null) {
			o.put("data", "");
		}else{
			o.put("data", user);
		}
		return o.toString();
	}
	
	
	@RequestMapping(value = "/delAdmin.do")
    @ResponseBody
    public JSONObject delAdmin(
    		Integer adminId
    		){
		JSONObject obj = new JSONObject();
		try {
			if(adminId!=null){
				adminUserService.delAdmin(adminId);
			}
			obj.put("code", "0");
		} catch (Exception e) {
			// TODO: handle exception
			obj.put("code", "1");
		}
		
		return obj;
	}
}
