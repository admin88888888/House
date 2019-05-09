package com.ddhouse.house.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ddhouse.house.common.JsonBean;
import com.ddhouse.house.entity.FEdubackgrounds;
import com.ddhouse.house.mapper.FEdubackgroundsMapper;
import com.ddhouse.house.service.FEdubackgroundsService;
import com.ddhouse.house.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cyx
 * @since 2019-04-27
 */
@Api(value = "用户学历模块",tags = "用户学历操作")
@RestController
public class FEdubackgroundsController {

    @Autowired
    private FEdubackgroundsMapper fEdubackgroundsMapper;

    @Autowired
    private FEdubackgroundsService fEdubackgroundsService;

    @GetMapping("/Edubackgrounds/selectUserEdubackgrounds.do")
    @ApiOperation(value = "获取用户学历信息",notes = "学历信息")
    public JsonBean selectUserEdubackgrounds(@RequestParam(value = "uid", required = false) int uid){

        QueryWrapper<FEdubackgrounds> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid",uid);
        FEdubackgrounds edubackgrounds = fEdubackgroundsMapper.selectOne(queryWrapper);

        return JsonUtils.createJsonBean(1000,null,edubackgrounds);

    }

    @PostMapping("/Edubackgrounds/addOrUpdate.do")
    @ApiOperation(value = "添加修改用户学历信息",notes = "添加修改学历信息")
    public JsonBean addUserEdubackgrounds(@RequestBody() FEdubackgrounds fEdubackgrounds){

        return  fEdubackgroundsService.addUserEdubackgrounds(fEdubackgrounds);

    }
}
