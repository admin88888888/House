package com.ddhouse.house.utils;


import com.ddhouse.house.common.JsonBean;

public class JsonUtils {
	public static JsonBean createJsonBean(int code, String msg, Object data) {
		JsonBean jsonBean = new JsonBean();
		jsonBean.setCode(code);
		jsonBean.setMsg(msg);
		jsonBean.setData(data);
		return jsonBean;
	}

	public static JsonBean setOK(){
		return createJsonBean(1000,"OK",null);
	}
	public static JsonBean setERROR(){
		return createJsonBean(0,"ERROR",null);
	}
	public static JsonBean setOK(String msg){
		return createJsonBean(1000,msg,null);
	}
}
