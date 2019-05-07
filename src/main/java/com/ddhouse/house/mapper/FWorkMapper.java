package com.ddhouse.house.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ddhouse.house.entity.FWork;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author cyx
 * @since 2019-04-27
 */
@Repository
public interface FWorkMapper extends BaseMapper<FWork> {

    /**
     * 预约工人
     * @param fWork
     */
    public void add(FWork fWork);

    /**
     * 展示工人信息(金牌维修员)
     * @return
     */
    public List<FWork> findAll();

    /**
     * 展示工人信息(金牌保洁员)
     * @return
     */
    public List<FWork> findClean();

}