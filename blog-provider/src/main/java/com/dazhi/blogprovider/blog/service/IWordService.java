package com.dazhi.blogprovider.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dazhi.blogprovider.blog.entity.Word;

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

    Word getBatch(String userId);

    void initTree(String grade, String userId);

    void initWord(String grade, String userId);

    List<Word> initAndGetWords(String grade, String userId);
}
