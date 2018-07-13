package com.htjy.util;

import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import com.htjy.dao.TaskDao;
@Service

public class UpdateStatusJob implements ApplicationListener<ContextRefreshedEvent>{

@Autowired

private TaskDao dao;//用到的容器内容

private Timer timer = null;
private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
private static SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");


@Override

public void onApplicationEvent(ContextRefreshedEvent evt) {

	if (evt.getApplicationContext().getParent() == null) {
		createSitemap();//调用任务需要做的事
	}
}

private void createSitemap() {
	Timer timer = new Timer("createSitemap", true);
	timer.schedule(new TimerTask() {
		@Override
		public void run() {
			initBack();
		}
	},0, 60000);//1分钟1扫描
	
	}
private TimerTask updateBackHalf() {
	dao.updateScheduleStatus();
	return null;
}
//初始化所有定时任务
@SuppressWarnings("deprecation")
public void initBack(){
	System.out.println("...start...");
    updateBackHalf();
   }

}