package com.ddhouse.house.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ddhouse.house.entity.FNews;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cyx
 * @since 2019-04-27
 */
public interface FNewsService extends IService<FNews> {
	//新闻展示
    public List<FNews> findAll();
}
