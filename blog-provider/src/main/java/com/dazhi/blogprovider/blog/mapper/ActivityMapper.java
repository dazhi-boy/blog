package com.dazhi.blogprovider.blog.mapper;

import com.dazhi.blogprovider.blog.entity.Activity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 景区列表 Mapper 接口
 * </p>
 *
 * @author dazhi
 * @since 2020-10-14
 */
public interface ActivityMapper extends BaseMapper<Activity> {

    public Activity getByIdWithDetail(@Param("id") Long id);
}
