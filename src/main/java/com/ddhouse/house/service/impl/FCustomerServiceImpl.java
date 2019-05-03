package com.ddhouse.house.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddhouse.house.entity.FCustomer;
import com.ddhouse.house.mapper.FCustomerMapper;
import com.ddhouse.house.service.FCustomerService;
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
public class FCustomerServiceImpl extends ServiceImpl<FCustomerMapper, FCustomer> implements FCustomerService {

    @Autowired
    private  FCustomerMapper fCustomerMapper;
    @Override
    public void add(FCustomer fCustomer) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("phone",fCustomer.getPhone());

        FCustomer f1 = fCustomerMapper.selectOne(queryWrapper);
        if(fCustomer.getPhone().length() != 11){
            throw new RuntimeException("手机号应为11位数");
        }
        if (!fCustomer.getPhone().matches("^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$")) {
            throw new RuntimeException("手机号格式不正确");
        }
        if (f1 != null) {
            throw new RuntimeException("该手机号已经注册过哟！");
        }
        fCustomerMapper.insert(fCustomer);

        QueryWrapper queryWrapper2 = new QueryWrapper();
        queryWrapper2.eq("idcard",fCustomer.getIdcard());

        FCustomer f2 = fCustomerMapper.selectOne(queryWrapper2);
        if(fCustomer.getIdcard() == null){
            throw new RuntimeException("请输入身份证号！");
        }
        if(fCustomer.getIdcard().length() != 15 && fCustomer.getIdcard().length() != 18){
            throw new RuntimeException("身份证号长度必须在15位或者18位！");
        }
        if (f2 != null){
            throw new RuntimeException("该身份证号已存在！");
        }
        fCustomerMapper.insert(fCustomer);
    }
}
