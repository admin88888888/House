package com.ddhouse.house.controller;

import com.ddhouse.house.common.JsonBean;
import com.ddhouse.house.entity.FUser;
import com.ddhouse.house.service.FUserService;
import com.ddhouse.house.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cyx
 * @since 2019-04-27
 */
@RestController
@Api(value = "用户相关操作", tags = "操作用户")
public class FUserController {

    @Autowired
    private FUserService fUserService;

    /*@GetMapping("/user/list.do")
    public List<FUser> findAllUser(){

        return fUserService.list();
    }*/

    /**
     * 注册账号
     * @param phone
     *      手机号
     * @param usernumber
     *      账号
     * @param password
     *      密码
     * @return
     */
    @PostMapping("/user/register.do")
    @ApiOperation(value = "注册新用户", notes = "实现用户新增")
    public JsonBean Register(String phone, String usernumber, String password){

        fUserService.Register(phone,usernumber,password);
        return JsonUtils.createJsonBean(1000,"注册成功",null);
    }
}
