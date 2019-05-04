package com.ddhouse.house.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ddhouse.house.common.JsonBean;
import com.ddhouse.house.entity.FHouseparticulars;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cyx
 * @since 2019-04-27
 */
public interface FHouseparticularsService extends IService<FHouseparticulars> {
    //房产信息展示
    List<FHouseparticulars> findAll();
}
