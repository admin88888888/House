package com.ddhouse.house.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ddhouse.house.common.JsonBean;
import com.ddhouse.house.entity.FEdubackgrounds;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cyx
 * @since 2019-04-27
 */
public interface FEdubackgroundsService extends IService<FEdubackgrounds> {

    JsonBean addUserEdubackgrounds(FEdubackgrounds fEdubackgrounds);
}
