package com.ddhouse.house.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ddhouse.house.entity.FMove;
import org.springframework.stereotype.Repository;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author cyx
 * @since 2019-04-27
 */
@Repository
public interface FMoveMapper extends BaseMapper<FMove> {

    int add(FMove fMove);

}