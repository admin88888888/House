package com.ddhouse.house.controller;


import com.ddhouse.house.common.JsonBean;
import com.ddhouse.house.entity.FHome;
import com.ddhouse.house.mapper.FHomeMapper;
import com.ddhouse.house.service.FHomeService;
import com.ddhouse.house.utils.JsonUtils;
import com.ddhouse.house.vo.VHomeInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ceg
 * @since 2019-04-27
 */
@RestController
@Api(value = "租房相关", tags = "租房模块")
public class FHomeController {

    @Autowired
    private FHomeMapper homeMapper;

    @Autowired
    private FHomeService fHomeService;
    /*@PostMapping("/home/list.do")
    public JsonBean selectHemoAll(FHome fHome){

        List<FHome> list = homeMapper.selectHomeByCondition(fHome);
        return JsonUtils.createJsonBean(1000,null, list);
    }*/

    @PostMapping("/home/homeList.do")
    @ApiOperation(value = "整租，合租，业主直租房,公寓，豪宅等房屋列表展示，通过条件显示", notes = "实现房屋展示")
    public JsonBean selectHemoAll(@RequestBody(required = false) FHome fHome){

        List<VHomeInfo> list = homeMapper.selectHomeByConditions(fHome);
        return JsonUtils.createJsonBean(1000,null, list);
    }

    @GetMapping("/home/homeDetails.do")
    @ApiOperation(value = "房屋详情展示", notes = "实现房屋详情展示")
    public JsonBean selectHomeDetails(@RequestParam(value = "id", required = false) int id){

        VHomeInfo info = fHomeService.selectHomeDetails(id);
        return JsonUtils.createJsonBean(1000,null,info);
    }

    @GetMapping("/home/selectHomeGoods.do")
    @ApiOperation(value = "公寓精选", notes = "公寓精选")
    public JsonBean selectHomeGoods(){

        List<FHome> list = homeMapper.selectHomeGoods();
        return JsonUtils.createJsonBean(1000,null,list);
    }

    @GetMapping("/home/selectHomeRecommend.do")
    @ApiOperation(value = "公寓推荐房型", notes = "公寓推荐房型")
    public JsonBean selectHomeRecommend(){

        List<VHomeInfo> list = homeMapper.selectHomeRecommend();
        return JsonUtils.createJsonBean(1000,null,list);
    }
    @GetMapping("/home/selectHomeById.do")
    @ApiOperation(value = "获取房屋信息", notes = "获取房屋信息")
    public JsonBean selectHomeById(@RequestParam(value = "id", required = false)int id){

        FHome home = homeMapper.selectById(id);
        return JsonUtils.createJsonBean(1000,null,home);
    }

}
