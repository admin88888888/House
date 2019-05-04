package com.ddhouse.house.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ddhouse.house.entity.FRules;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author cyx
 * @since 2019-04-27
 */
public interface FRulesMapper extends BaseMapper<FRules> {
    //佣金及合作规则展示
    public List<FRules> findAll();
}