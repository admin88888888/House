package com.ddhouse.house.controller;

import com.ddhouse.house.common.JsonBean;
import com.ddhouse.house.entity.FHouseparticulars;
import com.ddhouse.house.entity.FRules;
import com.ddhouse.house.mapper.FHouseparticularsMapper;
import com.ddhouse.house.mapper.FRulesMapper;
import com.ddhouse.house.service.FHouseparticularsService;
import com.ddhouse.house.service.FRulesService;
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
@Api(value = "佣金及合作规则展示", tags = "房屋买卖")
public class FRulesController {
    @Autowired
    private FRulesMapper fRulesMapper;

    @Autowired
    private FRulesService fRulesService;

    @GetMapping("/rules/show.do")
    @ApiOperation(value = "佣金及合作规则展示", notes = "实现房产信息展示")
    public JsonBean findAll(){
        List<FRules> list = fRulesService.findAll();
        return JsonUtils.createJsonBean(1000,null,list);
    }

}
