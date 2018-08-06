package com.htjy.websocket;

import javax.websocket.server.ServerEndpoint;


@ServerEndpoint(value="/newProduct/",configurator=GetHttpSessionConfigurator.class)
public class ProductSocket extends CommonSocket{
	 
	 /**
	  * 全部发送消息
	  * @param msg
	  */
	 public static void sendAllMessage(String msg) {
//		 CommonSocket.sendAllMessage(msg);
	 }
}
