package com.ddhouse.house.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ddhouse.house.entity.FWork;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cyx
 * @since 2019-04-27
 */
public interface FWorkService extends IService<FWork> {

    public void addWork(FWork fWork);
	
}
