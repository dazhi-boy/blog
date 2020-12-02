package com.dazhi.word.core.service.impl;

import com.dazhi.word.core.entity.Word;
import com.dazhi.word.core.mapper.WordMapper;
import com.dazhi.word.core.service.IWordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 单词表 服务实现类
 * </p>
 *
 * @author dazhi
 * @since 2020-12-02
 */
@Service
public class WordServiceImpl extends ServiceImpl<WordMapper, Word> implements IWordService {

}
