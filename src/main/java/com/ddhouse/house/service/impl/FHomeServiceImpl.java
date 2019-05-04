package com.ddhouse.house.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddhouse.house.entity.FHome;
import com.ddhouse.house.entity.FHomedetails;
import com.ddhouse.house.mapper.FHomeMapper;
import com.ddhouse.house.service.FHomeService;
import com.ddhouse.house.vo.VHomeInfo;
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
public class FHomeServiceImpl extends ServiceImpl<FHomeMapper, FHome> implements FHomeService {

    @Autowired
    private FHomeMapper fHomeMapper;
    @Override
    public VHomeInfo selectHomeDetails(int id) {

        VHomeInfo info = fHomeMapper.selectHomeDe(id);
        FHomedetails fHomedetails = fHomeMapper.selectHomeDetails(id);
        info.setHomedetails(fHomedetails);

        return info;
    }
}
