package com.ddhouse.house.service;

import com.ddhouse.house.common.JsonBean;


/**
 *@Author feri
 *@Date Created in 2019/4/29 10:48
 */
public interface CodeService {
    //发送
    JsonBean sendMsg(String phone);
    //重复发送  验证码不变
    JsonBean sendReMsg(String phone);
    //校验
    boolean checkCode(String phone, String code);

}
