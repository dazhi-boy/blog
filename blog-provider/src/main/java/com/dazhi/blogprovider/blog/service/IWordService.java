package com.dazhi.blogprovider.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dazhi.blogprovider.blog.entity.Word;

import java.io.IOException;

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
