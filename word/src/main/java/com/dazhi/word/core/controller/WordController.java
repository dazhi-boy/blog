package com.dazhi.word.core.controller;


import com.dazhi.word.common.Result;
import com.dazhi.word.core.entity.Word;
import com.dazhi.word.core.service.IWordService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.dazhi.word.common.BaseController;

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

    public Result init() {

        return Result.ok("初始化成功");
    }
}
