package com.ddhouse.house.service.impl;


import com.ddhouse.house.common.JsonBean;
import com.ddhouse.house.service.CodeService;
import com.ddhouse.house.utils.AliyunSmsUtil;
import com.ddhouse.house.utils.JedisUtil;
import com.ddhouse.house.utils.JsonUtils;
import com.ddhouse.house.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 *@Author feri
 *@Date Created in 2019/4/29 10:49
 */
@Service
public class CodeServiceImpl implements CodeService {
    @Autowired
    private JedisUtil jedisUtil;
    @Override
    public JsonBean sendMsg(String phone) {
        //先验证之前1分钟内是否发过短信、之前3分钟有没有过验证码
        if(jedisUtil.isExists("myRegister:"+phone)){
            return JsonUtils.setOK("请使用之前的验证码");
        }else {
            int code= RandomUtil.createNum(6);
            //存储验证码到Redis  2个key
            //1个key 用于短信失效  三分钟
            jedisUtil.setStr("myRegister:"+phone,code+"",1800);

            //1个key  1分钟只能发送一次
            jedisUtil.setStr("mySMS:"+phone,"",600);
            return JsonUtils.createJsonBean(AliyunSmsUtil.sendSms(phone,code)? 1000 : 0,"短信验证码发送成功",null);
        }
    }

    @Override
    public JsonBean sendReMsg(String phone) {
        //先验证之前1分钟内是否发过短信、之前3分钟有没有过验证码
        if(jedisUtil.isExists("mySMS:"+phone)) {
            if (jedisUtil.isExists("register:" + phone)) {
                //存在就重新把验证码发送一次
                String code=jedisUtil.getStr("register:" + phone);
                jedisUtil.setExpire("register:" + phone,180);
                return JsonUtils.createJsonBean(AliyunSmsUtil.sendSms(phone, Integer.parseInt(code)) ? 1000 : 0, "短信验证码发送成功", null);
            } else {
                //不存在 生成验证码
                int code = RandomUtil.createNum(6);
                //存储验证码到Redis  2个key
                //1个key 用于短信失效  三分钟
                jedisUtil.setStr("register:" + phone, code + "", 180);

                //1个key  1分钟只能发送一次
                jedisUtil.setStr("sms:" + phone, "", 60);
                return JsonUtils.createJsonBean(AliyunSmsUtil.sendSms(phone, code) ? 1000 : 0, "短信验证码发送成功", null);
            }
        }else {
            return JsonUtils.setOK("请稍后再试");
        }
    }

    @Override
    public boolean checkCode(String phone, String code) {
        String servercode=jedisUtil.getStr("myRegister:"+phone);
       if(Objects.equals(code,servercode)){
           //验证通过
           return true;
       }else {
           return false;
       }
    }
}
