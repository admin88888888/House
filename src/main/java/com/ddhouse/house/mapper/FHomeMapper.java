package com.ddhouse.house.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ddhouse.house.entity.FHome;
import com.ddhouse.house.entity.FHomedetails;
import com.ddhouse.house.vo.VHomeInfo;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author cyx
 * @since 2019-04-27
 */
public interface FHomeMapper extends BaseMapper<FHome> {

    /**
     *  通过条件获取房屋信息
     * @param home
     *      房屋条件
     * @return
     */
    List<FHome> selectHomeByCondition(FHome home);

    /**
     *  通过条件获取房屋信息
     * @param home
     *      房屋条件
     * @return
     */
    List<VHomeInfo> selectHomeByConditions(FHome home);

    /**
     * 通过房屋id获取房屋详细信息
     * @param hid
     * @return
     */
    FHomedetails selectHomeDetails(int hid);

    /**
     * 通过房屋id获取房屋信息
     * @param id
     * @return
     */
    VHomeInfo selectHomeDe(int id);

    /**
     * 公寓精选
     * @return
     */
    List<FHome> selectHomeGoods();

    /**
     * 推荐房型
     */
    List<VHomeInfo> selectHomeRecommend();
}