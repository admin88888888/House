package com.ddhouse.house.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddhouse.house.entity.FServe;
import com.ddhouse.house.mapper.FServeMapper;
import com.ddhouse.house.service.FServeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cyx
 * @since 2019-04-27
 */
@Service
public class FServeServiceImpl extends ServiceImpl<FServeMapper, FServe> implements FServeService {

    @Autowired
    private FServeMapper fServeMapper;

    @Override
    public void addAll(FServe fServe) {
        fServeMapper.add(fServe);
    }
}
