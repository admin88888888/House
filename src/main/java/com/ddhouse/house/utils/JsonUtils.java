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
}
