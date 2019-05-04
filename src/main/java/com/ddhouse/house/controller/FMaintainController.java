package com.ddhouse.house.controller;

import com.ddhouse.house.common.JsonBean;
import com.ddhouse.house.entity.FMaintain;
import com.ddhouse.house.service.FMaintainService;
import com.ddhouse.house.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@Api(value = "维修信息", tags = "维修")
public class FMaintainController {

    @Autowired
    private FMaintainService fMaintainService;

    @PostMapping("/maintain/add.do")
    @ApiOperation(value = "添加维修信息", notes = "添加维修信息")
    public JsonBean addByMaintain(FMaintain fMaintain){
        fMaintainService.addMaintain(fMaintain);
        return JsonUtils.createJsonBean(1000, "新增成功", null);
    }
	
}
