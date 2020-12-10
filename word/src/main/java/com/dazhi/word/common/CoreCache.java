package com.dazhi.word.common;

import com.dazhi.word.core.entity.Word;
import com.dazhi.word.core.entity.WordTree;

import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;

public class CoreCache {

    // 用于存储用户记忆单词的次数
    public static ConcurrentMap<Long, WordTree> WORD_TREE_CACHE = new ConcurrentHashMap<>();
    // 用于记录当前level
    public static ConcurrentMap<Long, Integer> CURRENT_LEVEL = new ConcurrentHashMap<>();
    // 用于记录所有计划好的单词
    public static ConcurrentMap<Long, Queue<Word>> WORD_QUEUE = new ConcurrentHashMap<>();

}
