package com.dazhi.blogprovider.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dazhi.blogprovider.blog.entity.Word;
import com.dazhi.blogprovider.blog.entity.WordGrade;
import com.dazhi.blogprovider.blog.service.IWordGradeService;
import com.dazhi.blogprovider.blog.service.IWordService;
import com.dazhi.blogprovider.blog.service.impl.WordServiceImpl;
import com.dazhi.blogprovider.common.BaseController;
import com.dazhi.blogprovider.common.Result;
import com.dazhi.blogprovider.util.GetImg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * <p>
 * 单词等级 前端控制器
 * </p>
 *
 * @author dazhi
 * @since 2021-06-22
 */
@RestController
@RequestMapping("/blog/word-grade")
@Api(value = "/blog/word-grade", tags = "WordGradeController", description = "单词分类")
public class WordGradeController extends BaseController<WordGrade, IWordGradeService> {
    @Autowired
    private IWordService iWordService;
    @Autowired
    private GetImg getImg;

    @GetMapping("/initImg")
    @ApiOperation(value = "初始化图片")
    public Result initImg() {
        String grade = "primary";
        QueryWrapper<Word> queryWrapper = new QueryWrapper();
        queryWrapper.eq("grade",grade);
        queryWrapper.isNull("user_id");
        queryWrapper.isNull("status");
        List<Word> list = iWordService.list(queryWrapper);
        for (int i = 271; i<list.size();i++) {
            Word word = list.get(i);
            String term = word.getTerm().trim();
            String path = "D:\\word\\"+grade+"\\"+term;
            try {
                getImg.getImg(term,path);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return Result.ok("初始化成功");
    }
}
