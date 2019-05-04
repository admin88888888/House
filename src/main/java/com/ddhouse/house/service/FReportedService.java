package com.ddhouse.house.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ddhouse.house.entity.FReported;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cyx
 * @since 2019-04-27
 */
public interface FReportedService extends IService<FReported> {
	//报备信息添加
    public void add(FReported fReported);
    //报备信息展示
    public List<FReported> findAll();
}
