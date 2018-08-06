package com.htjy.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.htjy.dao.TaskDao;
import com.htjy.entity.TaskModel;
import com.htjy.entity.TaskScheduleModel;
import com.htjy.entity.UserModel;
import com.htjy.util.CSVFileUtil;
import com.htjy.util.DateUtils;
import com.htjy.util.ReadUrlUtil;
import com.htjy.util.UploadUtil;

@Controller
@RequestMapping("/upload")
public class UploadController {
	
	@Autowired TaskDao taskDao;
	
	SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd");
	
	@ResponseBody
	@RequestMapping(value = "/uploadHead.do", method = RequestMethod.POST)
	public JSONObject uploadImg(
			@RequestParam("file") MultipartFile[] file,
			@RequestParam("aid") String aid,
			@RequestParam("address") String ad,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		JSONObject object = new JSONObject(); 
		JSONObject objectSrc = new JSONObject(); 
		String pathAll="";
		int q=0;
        if (null != file) {
        	System.out.println(111);
        	for (int j = 0; j < file.length; j++) {
        		MultipartFile fileSample = file[j];
        		String myFileName = fileSample.getOriginalFilename();//获取原始名字
        		if(myFileName.equals("")){
        			q++;
        		}
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
        	if(q>0){
        		response.setContentType("text/html;charset=utf-8");    
    			response.getWriter().write("<script>alert('上传不能存在空的图');window.location='../index/applyTask.html?aid="+aid+"' ;</script>");    
    			response.getWriter().flush();
    			return null;
        	}
        	pathAll = pathAll.substring(0, pathAll.length()-1);
            taskDao.updateTaskingStatus(pathAll,aid,ad);
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
            System.out.println("no file");
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
    
    
    @ResponseBody
	@RequestMapping(value = "/piaddTask.do", method = RequestMethod.POST)
	public JSONObject piaddTask(MultipartFile file,
			HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		JSONObject object = new JSONObject(); 
		
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
        file.transferTo(localFile);
        JSONObject o = readFromDtXLSX2007(path);
        if(o.get("code").equals("success")){
        	object.put("code", 0);
        	object.put("row", o.get("rep"));
        }else if(o.get("code").equals("fail")){
        	object.put("code", 1);
        }else{
        	object.put("code", 2);
        }
        return object;
    }

    
    /**
	 * 读取Excel2007,写入数据库的示例方法 （单个sheet）
	 * @param filePath
	 * @return
	 */
	public JSONObject readFromXLSX2007(String filePath) {  
		JSONObject object = new JSONObject(); 
        File excelFile = null;// Excel文件对象  
        InputStream is = null;// 输入流对象  
        TaskModel model = null;// 每一个任务对象
        String rep ="";
        try {  
            excelFile = new File(filePath);  
            is = new FileInputStream(excelFile);// 获取文件输入流  
//            XSSFWorkbook workbook2007 = new XSSFWorkbook(is);// 创建Excel2007文件对象
            org.apache.poi.ss.usermodel.Workbook workbook2007 = WorkbookFactory.create(is);
//            XSSFSheet sheet = workbook2007.getSheetAt(0);// 取出第一个工作表，索引是0 
            org.apache.poi.ss.usermodel.Sheet sheet = workbook2007.getSheetAt(0);
            // 开始循环遍历行，表头不处理，从1开始  
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {  
            	model = new TaskModel();// 实例化Student对象  
//            	HSSFRow row = sheet.getRow(i);// 获取行对象 
            	Row row = sheet.getRow(i);// 获取行对象  
                if (row == null) {// 如果为空，不处理
                    continue;  
                }  
                String line00 = row.getCell(0).getStringCellValue().trim();
                String line0 = row.getCell(1).getStringCellValue().trim();
                String line1 = row.getCell(2).getStringCellValue().trim();
                String line2 = row.getCell(3).getStringCellValue().trim();
                String line3 = row.getCell(4).getStringCellValue().trim();
                String line4 = row.getCell(5).getStringCellValue().trim();
                String line5 = row.getCell(6).getStringCellValue().trim();
                String line6 = row.getCell(7).getStringCellValue().trim();
                String line7 = row.getCell(8).getStringCellValue().trim();
                String line8 = row.getCell(9).getStringCellValue().trim();
                String line9 = row.getCell(10).getStringCellValue();
                model.setTitle("拍照片"+"-"+line0+"-"+line1+"-"+line6+line00);
				model.setType(line4);
				model.setLocation(line2);
				while (line2.endsWith("　")) {
					line2 = line2.substring(0, line2.length() - 1).trim();
				}
				JSONObject o = ReadUrlUtil.readJsonFromUrl("http://api.map.baidu.com/geocoder/v2/?address="+line2+"&output=json&ak=z1mGbIzrx8mkXmBl8Ik1Epyp"); 
				JSONObject result = (JSONObject) o.get("result");
				JSONObject element = (JSONObject) result.get("location");
				model.setLation(element.get("lat")+","+element.get("lng"));
				model.setAddress(line3);
				if(line6.indexOf("元")!=-1){
					model.setScore(Integer.parseInt(line6.substring(0, line6.length()-1)));
					model.setScoreFlag(1);
				}else{
					model.setScore(Integer.parseInt(line6.substring(0, line6.length()-1)));
					model.setScoreFlag(0);
				}
				model.setSchedule(line8);
				model.setSetPerson(1);
				model.setRemark(line9);
				switch (line7) {
				case "30分钟":
					model.setLockTime(0);
					break;
				case "1小时":
					model.setLockTime(1);
					break;
				case "2小时":
					model.setLockTime(2);
					break;
				default:
					model.setLockTime(0);
					break;
				}
				int r = taskDao.queryRepeat(model);
				if(r>0){
					rep = rep + i +",";
					continue;
				}
				taskDao.addTask(model);//增加任务
				Integer tid = model.getId();
				String[] dateBet = line8.split(" - ");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date dBegin = null;
				Date dEnd = null;
				try {
					dBegin = sdf.parse(dateBet[0]);
					dEnd = sdf.parse(dateBet[1]);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				List<Date> listDate = DateUtils.getDatesBetweenTwoDate(dBegin, dEnd);//生成时间集合
				List<TaskScheduleModel> listSche = new ArrayList<TaskScheduleModel>();
				for(int j=0;j<listDate.size();j++){
					TaskScheduleModel taskSche = new TaskScheduleModel();
					taskSche.setTid(tid);
					taskSche.setDaytime(listDate.get(j));
					listSche.add(taskSche);
				}
				taskDao.addTaskSchedule(listSche);
            }  
            object.put("code", "success");
            object.put("rep", rep);
            return object;
        } catch (IOException e) {  
            e.printStackTrace();  
            object.put("code", "fail");
            return object;
        } catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
		}finally {// 关闭文件流  
            if (is != null) {  
                try {  
                    is.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }
        return object; 
    }
	
	/**
	 * 读取Excel2007,写入数据库的示例方法 （单个sheet）
	 * @param filePath
	 * @return
	 */
	public JSONObject readFromDtXLSX2007(String filePath) throws ParseException {  
		JSONObject object = new JSONObject(); 
        File excelFile = null;// Excel文件对象  
        InputStream is = null;// 输入流对象  
        TaskModel model = null;// 每一个任务对象
        String rep ="";
        try {  
            excelFile = new File(filePath);  
            is = new FileInputStream(excelFile);// 获取文件输入流  
//            XSSFWorkbook workbook2007 = new XSSFWorkbook(is);// 创建Excel2007文件对象
            org.apache.poi.ss.usermodel.Workbook workbook2007 = WorkbookFactory.create(is);
//            XSSFSheet sheet = workbook2007.getSheetAt(0);// 取出第一个工作表，索引是0 
            org.apache.poi.ss.usermodel.Sheet sheet = workbook2007.getSheetAt(0);
            // 开始循环遍历行，表头不处理，从1开始  
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {  
            	model = new TaskModel();// 实例化Student对象  
//            	HSSFRow row = sheet.getRow(i);// 获取行对象 
            	Row row = sheet.getRow(i);// 获取行对象  
                if (row == null) {// 如果为空，不处理
                    continue;  
                }  
                String line0 = row.getCell(0)!=null?row.getCell(0).getStringCellValue().trim():"";//灯箱（）
                String line1 = row.getCell(1)!=null?row.getCell(1).getStringCellValue().trim():"";//灯箱（）
                String line2 = row.getCell(2)!=null?row.getCell(2).getStringCellValue().trim():"";//灯箱（）
                String line3 = row.getCell(3).getStringCellValue().trim();//灯箱（）
                String line4 = row.getCell(4).getStringCellValue().trim();//地铁站
                String line5 = row.getCell(5).getStringCellValue().trim();//酬金
                String line6 = row.getCell(6)!=null?row.getCell(6).getStringCellValue().trim():"";
                Date line7 = row.getCell(7).getDateCellValue();//开始日期
                Date line8 = row.getCell(8).getDateCellValue();//下刊日期
                String line9 = row.getCell(9).getStringCellValue();//注意事项
                double line10 = row.getCell(10).getNumericCellValue();//注意事项
                model.setTitle("拍照"+"-"+line3+"-"+line5);
				model.setType(line4);
				model.setLocation(line3);
				JSONObject o = ReadUrlUtil.readJsonFromUrl("http://api.map.baidu.com/geocoder/v2/?address="+line2+"&output=json&ak=z1mGbIzrx8mkXmBl8Ik1Epyp"); 
				JSONObject result = (JSONObject) o.get("result");
				JSONObject element = (JSONObject) result.get("location");
				model.setLation(element.get("lat")+","+element.get("lng"));
				model.setAddress(line4);
				if(line5.indexOf("元")!=-1){
					model.setScore(Integer.parseInt(line5.substring(0, line5.length()-1)));
					model.setScoreFlag(1);
				}else{
					model.setScore(Integer.parseInt(line5.substring(0, line5.length()-2)));
					model.setScoreFlag(0);
				}
				model.setPhotoNum((int)line10*2);
				model.setSchedule(sdff.format(line7)+" - "+sdff.format(line8));
				model.setSetPerson(1);
				model.setRemark(line9);
				int r = taskDao.queryRepeat(model);
				if(r>0){
					rep = rep + i +",";
					continue;
				}
				Calendar cal = Calendar.getInstance();
				// 使用给定的 Date 设置此 Calendar 的时间
				cal.setTime(line7);
				// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
				cal.add(Calendar.DAY_OF_MONTH, 2);
				model.setTruePeriod(sdff.format(line7)+" - "+sdff.format(cal.getTime()));
				taskDao.addTask(model);//增加任务
				Integer tid = model.getId();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date dBegin = null;
				dBegin = line7;
				List<Date> listDate = DateUtils.getDatesAfterDate(dBegin);//生成时间集合
				List<TaskScheduleModel> listSche = new ArrayList<TaskScheduleModel>();
				for(int j=0;j<listDate.size();j++){
					TaskScheduleModel taskSche = new TaskScheduleModel();
					taskSche.setTid(tid);
					taskSche.setDaytime(listDate.get(j));
					listSche.add(taskSche);
				}
				taskDao.addTaskSchedule(listSche);
				listSche.clear();
				
				Calendar call = Calendar.getInstance();
				// 使用给定的 Date 设置此 Calendar 的时间
				call.setTime(line8);
				// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
				call.add(Calendar.DAY_OF_MONTH, -2);
				model.setTruePeriod(sdff.format(call.getTime())+" - "+sdff.format(line8));
				taskDao.addTask(model);//增加任务
				Integer tid1 = model.getId();
				Date dEnd = null;
				dEnd = line8;
				List<Date> listDate1 = DateUtils.getDatesBeforeDate(dEnd);//生成时间集合
				for(int j=0;j<listDate1.size();j++){
					TaskScheduleModel taskSche = new TaskScheduleModel();
					taskSche.setTid(tid1);
					taskSche.setDaytime(listDate1.get(j));
					listSche.add(taskSche);
				}
				taskDao.addTaskSchedule(listSche);
				
            }  
            object.put("code", "success");
            object.put("rep", rep);
            return object;
        } catch (IOException e) {  
            e.printStackTrace();  
            object.put("code", "fail");
            return object;
        } catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
		}finally {// 关闭文件流  
            if (is != null) {  
                try {  
                    is.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }
        return object; 
    }
}