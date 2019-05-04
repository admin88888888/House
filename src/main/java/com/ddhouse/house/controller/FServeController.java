package com.ddhouse.house.controller;

import com.ddhouse.house.common.JsonBean;
import com.ddhouse.house.entity.FServe;
import com.ddhouse.house.service.FServeService;
import com.ddhouse.house.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "服务", tags = "服务")
public class FServeController {

    @Autowired
    private FServeService fServeService;

    @PostMapping("/serve/add.do")
    @ApiOperation(value = "添加服务", notes = "添加服务")
    public JsonBean addByAll(FServe fServe){
        fServeService.addAll(fServe);
        return JsonUtils.createJsonBean(1000, "新增成功", null);
    }

}
