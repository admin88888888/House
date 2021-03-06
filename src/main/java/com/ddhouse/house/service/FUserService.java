package com.ddhouse.house.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ddhouse.house.entity.FUser;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cyx
 * @since 2019-04-27
 */
public interface FUserService extends IService<FUser> {

    /**
     * 注册账号
     * @param phone
     *      手机号
     * @param usernumber
     *      账号
     * @param password
     *      密码
     */
    void Register(String phone, String usernumber, String password);

    int Login(String usernumber, String password, HttpServletRequest request);

    void updatePassword(String phone,String code ,String password,int id);
}
