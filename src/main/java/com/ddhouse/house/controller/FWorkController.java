package com.ddhouse.house.controller;

import com.ddhouse.house.common.JsonBean;
import com.ddhouse.house.entity.FWork;
import com.ddhouse.house.service.FWorkService;
import com.ddhouse.house.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
@Api(value = "工人信息", tags = "工人信息")
public class FWorkController {

    @Autowired
    private FWorkService fWorkService;

    @PostMapping("/work/add.do")
    @ApiOperation(value = "添加工人信息", notes = "添加工人信息")
    public JsonBean addByWork(@RequestBody(required = false)FWork fWork){
        fWorkService.addWork(fWork);
        return JsonUtils.createJsonBean(1000, "新增成功", null);
    }

    @GetMapping("/work/list.do")
    @ApiOperation(value = "展示维修员信息", notes = "展示维修员信息")
    public JsonBean findByWorkAll(){
        List<FWork> list = fWorkService.findWorkAll();
        return JsonUtils.createJsonBean(1000,null,list);
    }

    @GetMapping("/work/listclean.do")
    @ApiOperation(value = "展示保洁员信息", notes = "展示保洁员信息")
    public JsonBean findCleanWorkAll(){
        List<FWork> list = fWorkService.findCleanWork();
        return JsonUtils.createJsonBean(1000,null,list);
    }

}
