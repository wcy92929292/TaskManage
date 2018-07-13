package com.htjy.util;

/**
 * HTTP请求当个数据结果
 *
 * @author fuqin.li@ling9527.com
 * @version 2018年3月10日
 */
public class HttpRequestResultData<T> extends BaseHttpRequestResult{

	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
