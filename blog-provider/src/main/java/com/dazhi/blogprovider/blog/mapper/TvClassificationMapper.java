package com.dazhi.blogprovider.blog.mapper;

import com.dazhi.blogprovider.blog.entity.TvClassification;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 视频分类 Mapper 接口
 * </p>
 *
 * @author dazhi
 * @since 2020-11-04
 */
public interface TvClassificationMapper extends BaseMapper<TvClassification> {

    List<TvClassification> getWithDetailByPid(@Param("pid") Long pid);
}
