package com.dazhi.blogprovider.blog.controller;


import com.dazhi.blogprovider.blog.entity.WordGrade;
import com.dazhi.blogprovider.blog.service.IWordGradeService;
import com.dazhi.blogprovider.common.BaseController;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

}
