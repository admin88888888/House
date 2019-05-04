package com.ddhouse.house.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ddhouse.house.entity.FRules;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cyx
 * @since 2019-04-27
 */
public interface FRulesService extends IService<FRules> {
	//佣金及规则展示
    public List<FRules> findAll();
}
