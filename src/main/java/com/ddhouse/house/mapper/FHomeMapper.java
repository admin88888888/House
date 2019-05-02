package com.ddhouse.house.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ddhouse.house.entity.FHome;

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
}