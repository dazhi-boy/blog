package com.dazhi.word.common;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dazhi.word.core.entity.Word;
import com.dazhi.word.core.entity.WordTree;
import com.dazhi.word.core.service.IWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
public class CoreCache {

    // 用于存储用户记忆单词的次数
    public static ConcurrentMap<Long, WordTree> WORD_TREE_CACHE = new ConcurrentHashMap<>();
    // 用于记录当前level
    public static ConcurrentMap<Long, Integer> CURRENT_LEVEL = new ConcurrentHashMap<>();
    // 用于记录所有计划好的单词
    public static ConcurrentMap<Long, Queue<Word>> WORD_QUEUE = new ConcurrentHashMap<>();
    // 单词缓存
    public static ConcurrentMap<String, List<Word>> WORDS = new ConcurrentHashMap<>();

    @Autowired
    private IWordService iWordService;

    @PostConstruct
    public void init(){
        System.out.println("系统启动中。。。加载word");
        List<String> grades = new ArrayList<>();
        grades.add("primary");
        /*for (String grade : grades){
            QueryWrapper<Word> wrapper = new QueryWrapper();
            wrapper.eq("grade",grade);
            List<Word> codeList = iWordService.list(wrapper);
            WORDS.put(grade, codeList);
        }*/
    }

    @PreDestroy
    public void destroy(){
        System.out.println("系统运行结束");
    }
}
