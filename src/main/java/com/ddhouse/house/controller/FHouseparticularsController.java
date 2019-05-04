package com.ddhouse.house.controller;

import com.ddhouse.house.common.JsonBean;
import com.ddhouse.house.entity.FHouseparticulars;
import com.ddhouse.house.mapper.FCustomerMapper;
import com.ddhouse.house.mapper.FHouseparticularsMapper;
import com.ddhouse.house.service.FHomedetailsService;
import com.ddhouse.house.service.FHouseparticularsService;
import com.ddhouse.house.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@Api(value = "房产信息详情展示", tags = "房屋买卖")
public class FHouseparticularsController {
    @Autowired
    private FHouseparticularsMapper fHouseparticularsMapper;

    @Autowired
    private FHouseparticularsService fHouseparticularsService;
    @GetMapping("/houseparticulars/show.do")
    @ApiOperation(value = "房产信息详情展示", notes = "实现房产信息展示")
    public JsonBean findAll(){
        List<FHouseparticulars> list = fHouseparticularsService.findAll();
        return JsonUtils.createJsonBean(1000,null,list);
    }

}
