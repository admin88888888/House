package com.ddhouse.house.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddhouse.house.entity.FHouseparticulars;
import com.ddhouse.house.entity.FRules;
import com.ddhouse.house.mapper.FRulesMapper;
import com.ddhouse.house.service.FRulesService;
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
public class FRulesServiceImpl extends ServiceImpl<FRulesMapper, FRules> implements FRulesService {
    @Autowired
    public FRulesMapper fRulesMapper;
    @Override
    public List<FRules> findAll() {
        QueryWrapper queryWrapper = new QueryWrapper();
        List<FRules> list = fRulesMapper.selectList(queryWrapper);
        return list;
    }
}
