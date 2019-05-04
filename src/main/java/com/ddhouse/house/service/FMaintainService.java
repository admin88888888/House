package com.ddhouse.house.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ddhouse.house.entity.FMaintain;
import com.ddhouse.house.entity.FMove;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cyx
 * @since 2019-04-27
 */
public interface FMaintainService extends IService<FMaintain> {

    public void addMaintain(FMaintain fMaintain);
	
}
