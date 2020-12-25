package com.dazhi.word.core.mapper;

import com.dazhi.word.core.entity.Word;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 单词表 Mapper 接口
 * </p>
 *
 * @author dazhi
 * @since 2020-12-02
 */
public interface WordMapper extends BaseMapper<Word> {

    void initWord(@Param("grade") String grade, @Param("userId") Long userId);
}
