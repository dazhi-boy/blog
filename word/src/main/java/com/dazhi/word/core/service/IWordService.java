package com.dazhi.word.core.service;

import com.dazhi.word.core.entity.Word;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 单词表 服务类
 * </p>
 *
 * @author dazhi
 * @since 2020-12-02
 */
public interface IWordService extends IService<Word> {

    void init() throws IOException;

    void initTranslate();

    void initMusic();

    Word getBatch(Long userId);

    void initTree(String grade, Long userId);

    void initWord(String grade, Long userId);
}
