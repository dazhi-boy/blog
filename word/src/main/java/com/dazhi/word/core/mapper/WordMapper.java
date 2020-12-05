package com.dazhi.word.core.mapper;

import com.dazhi.word.core.entity.Word;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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

    List<Word> selectList();
}
