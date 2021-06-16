package com.dazhi.blogprovider.blog.mapper;

import com.dazhi.blogprovider.blog.entity.Food;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 美食列表 Mapper 接口
 * </p>
 *
 * @author dazhi
 * @since 2021-06-11
 */
public interface FoodMapper extends BaseMapper<Food> {

    List<Food> listRandFood(@Param("openId") String openId);

    Food randFood(@Param("openId") String openId, @Param("type") String type);
}
