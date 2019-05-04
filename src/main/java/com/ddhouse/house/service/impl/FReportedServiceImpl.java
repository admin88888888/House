package com.ddhouse.house.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddhouse.house.entity.FReported;
import com.ddhouse.house.mapper.FReportedMapper;
import com.ddhouse.house.service.FReportedService;
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
public class FReportedServiceImpl extends ServiceImpl<FReportedMapper, FReported> implements FReportedService {
    @Autowired
    public FReportedMapper fReportedMapper;
    @Override
    public void add(FReported fReported) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("cphone",fReported.getCphone());

        FReported f1 = fReportedMapper.selectOne(queryWrapper);
        if(fReported.getCphone().length() != 11){
            throw new RuntimeException("手机号应为11位数");
        }
        if (!fReported.getCphone().matches("^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$")) {
            throw new RuntimeException("手机号格式不正确");
        }
        if (f1 != null) {
            throw new RuntimeException("该手机号已经注册过哟！");
        }
        fReportedMapper.insert(fReported);
    }

    @Override
    public List<FReported> findAll() {
        QueryWrapper queryWrapper = new QueryWrapper();
        List<FReported> list = fReportedMapper.selectList(queryWrapper);
        return list;
    }
}
