package com.ddhouse.house.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddhouse.house.entity.FWork;
import com.ddhouse.house.mapper.FWorkMapper;
import com.ddhouse.house.service.FWorkService;
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
public class FWorkServiceImpl extends ServiceImpl<FWorkMapper, FWork> implements FWorkService {

    @Autowired
    private FWorkMapper fWorkMapper;

    @Override
    public void addWork(FWork fWork) {
        fWorkMapper.add(fWork);
    }

    @Override
    public List<FWork> findWorkAll() {
        List<FWork> list = fWorkMapper.findAll();
        return list;
    }

    @Override
    public List<FWork> findCleanWork() {
        List<FWork> list = fWorkMapper.findClean();
        return list;
    }
}
