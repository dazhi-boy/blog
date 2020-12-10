package com.dazhi.word.core.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dazhi.word.common.CoreCache;
import com.dazhi.word.common.Result;
import com.dazhi.word.core.entity.Word;
import com.dazhi.word.core.service.IWordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.dazhi.word.common.BaseController;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;

/**
 * <p>
 * 单词表 前端控制器
 * </p>
 *
 * @author dazhi
 * @since 2020-12-02
 */
@RestController
@RequestMapping("/core/word")
@Api(value = "/core/word", tags = "WordController", description = "单词管理接口")
public class WordController extends BaseController<Word, IWordService> {

    @GetMapping("/init")
    @ApiOperation(value = "初始化")
    public Result init() throws IOException {
        IWordService iWordService = (IWordService) super.iService;
        iWordService.init();
        return Result.ok("初始化成功");
    }

    @GetMapping("/initTranslate")
    @ApiOperation(value = "初始化翻译")
    public Result initTranslate() throws IOException {
        IWordService iWordService = (IWordService) super.iService;
        iWordService.initTranslate();
        return Result.ok("翻译成功");
    }

    @GetMapping("/initMusic")
    @ApiOperation(value = "初始化读音")
    public Result initMusic() throws IOException {
        IWordService iWordService = (IWordService) super.iService;
        iWordService.initMusic();
        return Result.ok("初始化读音");
    }

    @GetMapping("/initTree")
    @ApiOperation(value = "初始化单词树")
    public Result initTree() throws IOException {
        IWordService iWordService = (IWordService) super.iService;
        iWordService.initTree();
        return Result.ok("初始化单词树");
    }

    @GetMapping("/getBatch")
    @ApiOperation(value = "获取一批单词")
    public Result<Word> getBatch() throws IOException {
        IWordService iWordService = (IWordService) super.iService;
        Word word = iWordService.getBatch();

//        IPage<Word> page = new Page<>(1, 5);
//
//        QueryWrapper<Word> queryWrapper = new QueryWrapper<>();
//
//        CoreCache.wordFrequencyCache.get("1");
//        queryWrapper.eq("frequency", "");
//        IPage<Word> tPage = iWordService.page(page, queryWrapper);

        Result<Word> result = Result.ok("OK");
        result.setData(word);
        return result;
    }


    public static void main(String[] args) {
        int frequency = 1;

        int group = 1;
        for (int j = 0; j<2; j++) {
            group += j;
            for (int i = 0; i < 2; i++) {
                System.out.println(group);
            }
        }
    }
}
