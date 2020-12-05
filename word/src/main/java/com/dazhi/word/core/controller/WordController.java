package com.dazhi.word.core.controller;


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
}
