package com.ddhouse.house.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddhouse.house.entity.FHouseparticulars;
import com.ddhouse.house.entity.FNews;
import com.ddhouse.house.mapper.FNewsMapper;
import com.ddhouse.house.service.FNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cyx
 * @since 2019-04-27
 */
@Service
public class FNewsServiceImpl extends ServiceImpl<FNewsMapper, FNews> implements FNewsService {
    @Autowired
    public FNewsMapper fNewsMapper;

    @Override
    public List<FNews> findAll() {
        QueryWrapper queryWrapper = new QueryWrapper();
        List<FNews> list = fNewsMapper.selectList(queryWrapper);
        return list;
    }
}
