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
//        String grade = "primary";//小学
//        String grade = "middle";//初中
//        String grade = "senior1";//高中1
//        String grade = "senior2";//高中2
//        String grade = "senior3";//高中3
//        String grade = "senior4";//高中4
//        String grade = "senior5";//高中5
//        String grade = "senior6";//高中6
//        String grade = "senior7";//高中7
        String grade = "senior8";//高中8
//        String grade = "senior9";//高中9
//        String grade = "senior10";//高中10
//        String grade = "senior11";//高中11
        QueryWrapper<Word> queryWrapper = new QueryWrapper();
        queryWrapper.eq("grade",grade);
        queryWrapper.isNull("user_id");
        queryWrapper.isNull("status");
        List<Word> list = iWordService.list(queryWrapper);
        for (int i = 0; i<60;i++) {
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
