package com.ddhouse.house.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddhouse.house.common.JsonBean;
import com.ddhouse.house.entity.FEdubackgrounds;
import com.ddhouse.house.mapper.FEdubackgroundsMapper;
import com.ddhouse.house.service.FEdubackgroundsService;
import com.ddhouse.house.utils.JsonUtils;
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
public class FEdubackgroundsServiceImpl extends ServiceImpl<FEdubackgroundsMapper, FEdubackgrounds> implements FEdubackgroundsService {

    @Autowired
    private FEdubackgroundsMapper fEdubackgroundsMapper;

    @Override
    public JsonBean addUserEdubackgrounds(FEdubackgrounds fEdubackgrounds) {

        QueryWrapper<FEdubackgrounds> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid",fEdubackgrounds.getUid());
        FEdubackgrounds edubackgrounds = fEdubackgroundsMapper.selectOne(queryWrapper);

        if(edubackgrounds == null){
            fEdubackgroundsMapper.insert(fEdubackgrounds);
            return JsonUtils.createJsonBean(1000,"添加成功！",null);

        } else {
            fEdubackgroundsMapper.update(fEdubackgrounds,queryWrapper);
            return JsonUtils.createJsonBean(1000,"修改成功！",null);
        }

    }
}
