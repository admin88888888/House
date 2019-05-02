package com.ddhouse.house.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ddhouse.house.common.JsonBean;
import com.ddhouse.house.entity.FHome;
import com.ddhouse.house.mapper.FHomeMapper;
import com.ddhouse.house.utils.JsonUtils;
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
public class FHomeController {

    @Autowired
    private FHomeMapper homeMapper;

    @PostMapping("/home/list.do")
    public JsonBean selectHemoAll(FHome fHome){

        List<FHome> list = homeMapper.selectHomeByCondition(fHome);
        return JsonUtils.createJsonBean(1000,null, list);
    }
}
