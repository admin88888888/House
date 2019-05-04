package com.ddhouse.house.controller;

import com.ddhouse.house.common.JsonBean;
import com.ddhouse.house.entity.FNews;
import com.ddhouse.house.mapper.FNewsMapper;
import com.ddhouse.house.service.FNewsService;
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
@Api(value = "新闻展示",tags = "房屋买卖")
public class FNewsController {
	@Autowired
    public FNewsMapper fNewsMapper;
	@Autowired
    public FNewsService fNewsService;

	@GetMapping("/fnews/show.do")
    @ApiOperation(value = "新闻展示",notes = "实现房产新闻的展示")
    public JsonBean findAll(){
        List<FNews> list = fNewsService.findAll();
        return JsonUtils.createJsonBean(1000,null,list);
    }
}
