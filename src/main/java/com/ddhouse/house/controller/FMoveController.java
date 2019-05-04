package com.ddhouse.house.controller;

import com.ddhouse.house.common.JsonBean;
import com.ddhouse.house.entity.FMove;
import com.ddhouse.house.service.FMoveService;
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
@Api(value = "搬家服务", tags = "搬家服务")
public class FMoveController {

    @Autowired
    private FMoveService fMoveService;

    @PostMapping("/move/add.do")
    @ApiOperation(value = "添加搬家信息", notes = "添加搬家信息")
    public JsonBean addByMove(FMove fMove){
        fMoveService.addMove(fMove);
        return JsonUtils.createJsonBean(1000, "新增成功", null);
    }
	
}
