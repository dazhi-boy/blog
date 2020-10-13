package com.dazhi.blogprovider.blog.mapper;

import com.dazhi.blogprovider.blog.entity.Attractions;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * <p>
 * 景区列表 Mapper 接口
 * </p>
 *
 * @author dazhi
 * @since 2020-10-13
 */
public interface AttractionsMapper extends BaseMapper<Attractions> {

    public Attractions getByIdWithDetail(@Param("id") Long id);
}
