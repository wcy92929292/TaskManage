package com.htjy.websocket;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.http.HttpSession;
import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import com.htjy.entity.UserModel;

public class CommonSocket {

		//开奖连接的终端数
		 protected static final Set<CommonSocket> connections =new CopyOnWriteArraySet<>();
		 protected Session session = null;
		 protected Integer userId ;
		 protected long maxIdleTimeout = 600000;	//socket连接时间保持10分钟
		 
		 /**
		  * 当客户端链接
		  * @param session
		  * @throws IOException
		  */
		 @OnOpen
		 public void onOpen(EndpointConfig config,Session session) throws IOException {
			 this.session = session;
			 session.setMaxIdleTimeout(maxIdleTimeout);
			 HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
			 UserModel u = (UserModel) httpSession.getAttribute("user");
			 if(u!=null){
				 this.userId = u.getId();
			 }
			 connections.add(this);
			 System.out.println(connections.size()+"==connections=====");
		 }
		 
		 
		 /**
		  * 当信息接收到时触发
		  * @param message
		  * @return
		  */
		 @OnMessage
		 public String onMessage(String message) {
			return message;
		 }

		 @OnError
		 public void onError(Throwable t) {
			 System.out.println("onError:"+t);
		 }
		
		 /**
		  * 当连接关闭时，触发
		  * @param session
		  * @param reason
		  */
		 @OnClose
		 public void onClose(Session session, CloseReason reason) {
			 connections.remove(this);
		 } 
		 
		 /**
		  * 全部发送消息
		  * @param msg
		 * @param list 
		  */
		 public static void sendAllMessage(String msg, List<Integer> list) {
			 
		        for (CommonSocket client : connections) {
		            try {
		                synchronized (client) {
	                		if(list.contains(client.userId)){
	                			System.out.println(msg);
			                    client.session.getBasicRemote().sendText(msg);
	                		}
		                }
		            } catch (Exception e) {
		                connections.remove(client);
		                try {
		                    client.session.close();
		                } catch (IOException e1) {}
		            }
		        }
		  }
}
