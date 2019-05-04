package com.ddhouse.house.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddhouse.house.entity.FHouseparticulars;
import com.ddhouse.house.mapper.FHouseparticularsMapper;
import com.ddhouse.house.service.FHouseparticularsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
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
public class FHouseparticularsServiceImpl extends ServiceImpl<FHouseparticularsMapper, FHouseparticulars> implements FHouseparticularsService {
    @Autowired
    public FHouseparticularsMapper fHouseparticularsMapper;

    @Override
    public List<FHouseparticulars> findAll() {
        QueryWrapper queryWrapper = new QueryWrapper();
        List<FHouseparticulars> list = fHouseparticularsMapper.selectList(queryWrapper);
        return list;
    }


}
