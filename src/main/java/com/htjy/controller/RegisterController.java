package com.htjy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.htjy.dao.UserDao;
import com.htjy.entity.UserModel;
import com.htjy.util.MobileMessageCheck;
import com.htjy.util.MobileMessageSend;

/**
 * 2018年7月4日
 * wcy
 */
@Controller
@RequestMapping("/user")
public class RegisterController {
	
	@Autowired UserDao userDao;
	/**
	 * 获取验证码
	 * @param phone
	 * @return
	 */
	@RequestMapping(value = "/register.do")
    @ResponseBody
    public JSONObject register(
  		@RequestParam("phone") String phone){
		JSONObject obj = new JSONObject();
	    try {
	    	UserModel u = userDao.getUserByPhone(phone);
	    	if(u==null){
	    		String str = MobileMessageSend.sendMsg(phone);
//		    	String str = "success";
		        if("success".equals(str)){
		            System.out.println("发送成功！");
		            obj.put("code", "0");
		            return obj;
		        }else{
		            System.out.println("发送失败！");
		            obj.put("code", "1");
		            return obj;
		        }
	    	}else{
	    		obj.put("code", "3");
		        return obj;
	    	}
	        
	    } catch (Exception e) {
	        // TODO: handle exception
	        e.printStackTrace();
	        obj.put("code", "2");
	        return obj;
	    }
		
	}
	/**
	 * 校验验证码 入库
	 * @param phone
	 * @param password
	 * @param checkCode
	 * @return
	 */
	@RequestMapping(value = "/checkCode.do")
    @ResponseBody
    public JSONObject checkCode(
  		@RequestParam("phone") String phone,
  		@RequestParam("password") String password,
  		@RequestParam("checkCode") String checkCode){
		JSONObject obj = new JSONObject();
		String mobileNumber = phone;//手机号码
        String code = checkCode;//验证码
        try {
            String str = MobileMessageCheck.checkMsg(mobileNumber,code);
            if("success".equals(str)){
            	String filename=RandomStringUtils.randomAlphanumeric(6);
            	UserModel user = new UserModel();
            	user.setLoginName(filename);
            	user.setPhone(phone);
            	user.setPassword(password);
            	userDao.addUser(user);
            	userDao.addUserScore(user.getId()+"");
                System.out.println("验证成功！");
                obj.put("code", "0");
                return obj;
            }else{
                System.out.println("验证失败！");
                obj.put("code", "1");
                return obj;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            obj.put("code", "2");
            return obj;
        }
		
	}
	/**
	 * 登录
	 * @param phone
	 * @param password
	 * @return
	 */
	@RequestMapping("/loginOn.do")
	@ResponseBody
	public JSONObject loginOn(
			@RequestParam("phone") String phone,
	  		@RequestParam("password") String password,
	  		HttpServletRequest request){
		
		JSONObject obj = new JSONObject();
		UserModel u = userDao.login(phone, password);
		if(u==null){
			obj.put("code", "1");
			return obj;
		}else{
			obj.put("code", "0");
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
			return obj;
		}
	}
	/**
	 * 获取当前session用户
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("/getUserSession.do")
	@ResponseBody
	public JSONObject getUserSession(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		UserModel u = (UserModel) session.getAttribute("user");
		JSONObject o = new JSONObject();
		if(u==null){
			o.put("code", "1");
			o.put("data", "");
		}else{
			o.put("code", "0");
			o.put("data", u);
		}
		return o;
	}
	
	@ResponseBody
	@RequestMapping(value = "logout.do", method = { RequestMethod.POST, RequestMethod.GET })
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		response.sendRedirect("../index/login.html?next=personal");
	}
	
	@ResponseBody
	@RequestMapping("/getUserList.do")
	public JSONObject getUserList(){
		JSONObject obj = new JSONObject();
		List<UserModel> ulist = userDao.getUserList();
		obj.put("code", "0");
		obj.put("result", ulist);
		return obj;
	}
}
