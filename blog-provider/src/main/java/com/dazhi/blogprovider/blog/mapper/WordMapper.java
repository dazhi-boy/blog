package com.dazhi.blogprovider.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dazhi.blogprovider.blog.entity.Word;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 单词表 Mapper 接口
 * </p>
 *
 * @author dazhi
 * @since 2020-12-02
 */
public interface WordMapper extends BaseMapper<Word> {

    void initWord(@Param("grade") String grade, @Param("userId") String userId);
}
