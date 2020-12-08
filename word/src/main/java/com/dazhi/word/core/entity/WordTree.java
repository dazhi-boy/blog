package com.dazhi.word.core.entity;

import java.util.ArrayList;
import java.util.List;

public class WordTree {
    private List<Words> wordsList = new ArrayList<>();

    // 添加一个words
    public void addWords(List<Word> wordList) {
        Words words = new Words();
        words.setFrequency(0);
        words.setWords(wordList);
        wordsList.add(words);
    }

    public List<Words> getWordsList() {
        return wordsList;
    }

    public void setWordsList(List<Words> wordsList) {
        this.wordsList = wordsList;
    }

    public class Words {
        private Integer frequency;
        private List<Word> words = new ArrayList<>();

        public Integer getFrequency() {
            return frequency;
        }

        public void setFrequency(Integer frequency) {
            this.frequency = frequency;
        }

        public List<Word> getWords() {
            return words;
        }

        public void setWords(List<Word> words) {
            this.words = words;
        }
    }
}
