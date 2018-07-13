package com.htjy.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.htjy.dao.TaskDao;
import com.htjy.entity.UserModel;
import com.htjy.util.UploadUtil;

@Controller
@RequestMapping("/upload")
public class UploadController {
	
	@Autowired TaskDao taskDao;
	
	@ResponseBody
	@RequestMapping(value = "/uploadHead.do", method = RequestMethod.POST)
	public JSONObject uploadImg(
			@RequestParam("file") MultipartFile[] file,
			@RequestParam("aid") String aid,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		JSONObject object = new JSONObject(); 
		JSONObject objectSrc = new JSONObject(); 
		String pathAll="";
        if (null != file) {
        	System.out.println(111);
        	for (int j = 0; j < file.length; j++) {
        		MultipartFile fileSample = file[j];
        		String myFileName = fileSample.getOriginalFilename();//获取原始名字
                String fileName = //BasePath.getImgPath("yyyyMMddHHmmss")+
                        Integer.toHexString(new Random().nextInt()) +"."+ myFileName.
                        substring(myFileName.lastIndexOf(".") + 1);  
                File fileDir=new File(UploadUtil.getUploadPath());
                if (!fileDir.exists()) { 
                     fileDir.mkdirs();    
                 } 
                String path=UploadUtil.getUploadPath()+fileName;
                File localFile = new File(path);  
                try {
					fileSample.transferTo(localFile);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                pathAll=pathAll+fileName+",";
			}
        	pathAll = pathAll.substring(0, pathAll.length()-1);
            taskDao.updateTaskingStatus(pathAll,aid);
            objectSrc.put("src", pathAll);
            object.put("code", 0);
            object.put("msg", "");
            object.put("data", objectSrc);
            response.sendRedirect("../index/applySuccess.html");
            return null;
        }else{
            System.out.println("no file");
        }
        return null;
    }
	
	@ResponseBody
	@RequestMapping(value = "/uploadQrc.do", method = RequestMethod.POST)
	public JSONObject uploadQrc(MultipartFile file,@RequestParam("flag") String flag,HttpSession session) {
		JSONObject object = new JSONObject(); 
		JSONObject objectSrc = new JSONObject(); 
		UserModel u = (UserModel)session.getAttribute("user");
        if (null != file) {
            String myFileName = file.getOriginalFilename();//获取原始名字
            String fileName = //BasePath.getImgPath("yyyyMMddHHmmss")+
                    Integer.toHexString(new Random().nextInt()) +"."+ myFileName.
                    substring(myFileName.lastIndexOf(".") + 1);  
            File fileDir=new File(UploadUtil.getUploadPath());
            if (!fileDir.exists()) { 
                 fileDir.mkdirs();    
             } 
            String path=UploadUtil.getUploadPath()+fileName;
            File localFile = new File(path);  
            try {
                file.transferTo(localFile);
                taskDao.updateQrc(fileName,flag,u.getId()+"");
                objectSrc.put("src", fileName);
                object.put("code", 0);
                object.put("msg", "");
                object.put("data", objectSrc);
                return object;
            } catch (IllegalStateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            System.out.println("�ļ�Ϊ��");
        }
        return null;
    }
	
	
    @RequestMapping(value = "/read.do")  
    @ResponseBody  
    public String createFolw(HttpServletRequest request,  
            HttpServletResponse response,
            @RequestParam("name") String name) {  
        FileInputStream fis = null;  
        OutputStream os = null;  
        if(name==null ||name==""){
        	return "no";  
        }
        try {  
            fis = new FileInputStream(UploadUtil.getUploadPath()+name);  
            os = response.getOutputStream();  
            int count = 0;  
            byte[] buffer = new byte[1024 * 8];  
            while ((count = fis.read(buffer)) != -1) {  
                os.write(buffer, 0, count);  
                os.flush();  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        try {  
            fis.close();  
            os.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return "ok";  
    }  
}
