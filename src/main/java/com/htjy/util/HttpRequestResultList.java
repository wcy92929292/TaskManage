package com.htjy.util;

import java.util.LinkedList;
import java.util.List;

/**
 * HTTP请求List结果
 *
 * @author fuqin.li@ling9527.com
 * @version 2018年3月10日
 */
public class HttpRequestResultList<T> extends BaseHttpRequestResult{

	private List<T> list = new LinkedList<T>();

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		if(list == null ) {
			return;
		}
		this.list = list;
	}
	
}
