package com.ddhouse.house.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddhouse.house.entity.FMaintain;
import com.ddhouse.house.mapper.FMaintainMapper;
import com.ddhouse.house.service.FMaintainService;
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
public class FMaintainServiceImpl extends ServiceImpl<FMaintainMapper, FMaintain> implements FMaintainService {

    @Autowired
    private FMaintainMapper fMaintainMapper;

    @Override
    public void addMaintain(FMaintain fMaintain) {
        fMaintainMapper.add(fMaintain);
    }
}
