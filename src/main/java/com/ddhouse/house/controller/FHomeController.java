package com.ddhouse.house.controller;


import com.ddhouse.house.common.JsonBean;
import com.ddhouse.house.entity.FHome;
import com.ddhouse.house.mapper.FHomeMapper;
import com.ddhouse.house.utils.JsonUtils;
import com.ddhouse.house.vo.VHomeInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
@Api(value = "租房相关", tags = "房屋出租")
public class FHomeController {

    @Autowired
    private FHomeMapper homeMapper;

    /*@PostMapping("/home/list.do")
    public JsonBean selectHemoAll(FHome fHome){

        List<FHome> list = homeMapper.selectHomeByCondition(fHome);
        return JsonUtils.createJsonBean(1000,null, list);
    }*/

    @PostMapping("/home/homeList.do")
    @ApiOperation(value = "房屋展示", notes = "实现房屋展示")
    public JsonBean selectHemoAll(FHome fHome){

        List<VHomeInfo> list = homeMapper.selectHomeByConditions(fHome);
        return JsonUtils.createJsonBean(1000,null, list);
    }
}
