package com.ddhouse.house.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ddhouse.house.entity.FHome;
import com.ddhouse.house.entity.FHomedetails;
import com.ddhouse.house.vo.VHomeInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cyx
 * @since 2019-04-27
 */
public interface FHomeService extends IService<FHome> {

    /**
     * 通过房屋id获取房屋详细信息
     * @param id
     * @return
     */
    VHomeInfo selectHomeDetails(int id);
}
