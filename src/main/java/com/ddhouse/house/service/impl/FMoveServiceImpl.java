package com.ddhouse.house.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddhouse.house.entity.FMove;
import com.ddhouse.house.mapper.FMoveMapper;
import com.ddhouse.house.service.FMoveService;
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
public class FMoveServiceImpl extends ServiceImpl<FMoveMapper, FMove> implements FMoveService {

    @Autowired
    private FMoveMapper fMoveMapper;

    @Override
    public void addMove(FMove fMove) {
        fMoveMapper.add(fMove);
    }
}
