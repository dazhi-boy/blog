package com.dazhi.word.core.service.impl;

import com.dazhi.word.core.entity.Word;
import com.dazhi.word.core.mapper.WordMapper;
import com.dazhi.word.core.service.IWordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.*;

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

    @Override
    public void init() throws IOException {
        // 1. 读取文件
        BufferedReader bufferedReader = new BufferedReader(new FileReader(Thread.currentThread().getContextClassLoader().getResource("world.txt").getFile()));
        // 2. 遍历
        String text;
        while ((text = bufferedReader.readLine()) != null) {
            // 3. 保存文件
//            System.out.println(text);
            Word word = new Word();
            word.setTerm(text);
            word.setGrade("primary");
            try {
                super.baseMapper.insert(word);
            }catch (Exception e){
                System.out.println(text + "重复");
            }
        }
        bufferedReader.close();
    }
}
