package com.ddhouse.house.controller;

import com.ddhouse.house.common.JsonBean;
import com.ddhouse.house.entity.FUser;
import com.ddhouse.house.mapper.FUserMapper;
import com.ddhouse.house.service.CodeService;
import com.ddhouse.house.service.FUserService;
import com.ddhouse.house.utils.JedisUtil;
import com.ddhouse.house.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @Autowired
    private FUserMapper fUserMapper;

    @Autowired
    private CodeService codeService;

    @Autowired
    private JedisUtil jedisUtil;

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
    public JsonBean Register(@RequestParam(value = "phone",required=false) String phone, @RequestParam(value = "usernumber",required=false) String usernumber,@RequestParam(value = "password",required=false) String password){

        fUserService.Register(phone,usernumber,password);
        return JsonUtils.createJsonBean(1000,"注册成功",null);
    }

    @PostMapping("/user/login.do")
    @ApiOperation(value = "用户登录,【返回值id为用户id 要传递给获取用户和退出操作】", notes = "判断用户登录")
    public JsonBean Login(@RequestParam(value = "usernumber",required=false)String usernumber, @RequestParam(value = "password",required=false)String password,HttpServletRequest request){

        int id = fUserService.Login(usernumber, password, request);
        return JsonUtils.createJsonBean(1000,"登录成功",id);
    }


    //发送验证码  一份钟发送1次  验证码3分钟失效
    @ApiOperation(value = "发送短信验证码",notes = "发送短信验证码")
    @PostMapping("/user/sendmsg.do")
    public JsonBean sendMsg(@RequestParam(value = "phone",required=false)String phone){
        return codeService.sendMsg(phone);
    }
    //
    @ApiOperation(value = "校验短信验证码,并修改密码",notes = "校验短信验证码,并修改密码")
    @PostMapping("/user/updatePassWord.do")
    public JsonBean updatePassWord(@RequestParam(value = "phone",required=false)String phone,@RequestParam(value = "code",required=false)String code,@RequestParam(value = "password",required=false)String password){

        int id = Integer.parseInt(jedisUtil.getStr("fUserId"));
        fUserService.updatePassword(phone,code,password,id);
        return JsonUtils.setOK("修改成功");
    }


    @ApiOperation(value = "获取登录用户的信息",notes = "获取登录用户的信息")
    @GetMapping("/user/selectLoginUser.do")
    public JsonBean selectLoginUser(HttpServletRequest request){

        HttpSession session = request.getSession();
        FUser fUser = (FUser) session.getAttribute("fUser");
        if(fUser != null){

            if(!jedisUtil.isExists("fUserId"+fUser.getId())){
                String msg = "用户未登录，请重新登录";
                return JsonUtils.createJsonBean(1000,msg,null);
            }
        }


        return JsonUtils.createJsonBean(1000,null,fUser);
    }

    @ApiOperation(value = "用户退出登录",notes = "用户退出登录")
    @GetMapping("/user/loginOut.do")
    public  JsonBean loginOut(HttpServletRequest request){

        HttpSession session = request.getSession();
        FUser fUser = (FUser) session.getAttribute("fUser");
        if(fUser != null){

            jedisUtil.delKey("fUserId"+fUser.getId());
            session.removeAttribute("fUser");
        }
        return JsonUtils.createJsonBean(1000,"退出成功",null);
    }
}
