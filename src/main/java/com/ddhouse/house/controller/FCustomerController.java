package com.ddhouse.house.controller;

import com.ddhouse.house.common.JsonBean;
import com.ddhouse.house.entity.FCustomer;
import com.ddhouse.house.mapper.FCustomerMapper;
import com.ddhouse.house.service.FCustomerService;
import com.ddhouse.house.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cyx
 * @since 2019-04-27
 */
@RestController
public class FCustomerController {
    @Autowired
    private FCustomerMapper fCustomerMapper;

    @Autowired
    private FCustomerService fCustomerService;
    @PostMapping("customer/add.do")
    public JsonBean add(FCustomer fCustomer){
        fCustomerService.add(fCustomer);
        return JsonUtils.createJsonBean(1000,"添加成功",null);
    }
}
