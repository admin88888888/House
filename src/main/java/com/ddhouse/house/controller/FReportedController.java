package com.ddhouse.house.controller;

import com.ddhouse.house.common.JsonBean;
import com.ddhouse.house.entity.FReported;
import com.ddhouse.house.service.FReportedService;
import com.ddhouse.house.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@Api(value = "快速报备信息添加", tags = "房屋买卖")
public class FReportedController {
	@Autowired
    public FReportedService fReportedService;
	@PostMapping("/reported/add.do")
    @ApiOperation(value = "快速报备信息添加", notes = "实现快速报备信息添加")
    public JsonBean add(@RequestBody(required = false)FReported fReported){
	    fReportedService.add(fReported);
        return JsonUtils.createJsonBean(1000,"报备成功",null);
    }
    @PostMapping("/reported/show.do")
    @ApiOperation(value = "报备信息展示", notes = "实现报备信息展示")
    public JsonBean findAll(){
        List<FReported> list = fReportedService.findAll();
        return JsonUtils.createJsonBean(1000,"总条数:"+String.valueOf(list.size())+"条",list);
    }
}
