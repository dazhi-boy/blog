package com.dazhi.blogprovider.blog.controller;


import com.dazhi.blogprovider.blog.entity.TvClassification;
import com.dazhi.blogprovider.blog.service.ITvClassificationService;
import com.dazhi.blogprovider.common.BaseController;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 视频分类 前端控制器
 * </p>
 *
 * @author dazhi
 * @since 2020-11-04
 */
@RestController
@RequestMapping("/blog/tv-classification")
@Api(value = "/blog/tv-classification", tags = "TvClassificationController", description = "视频分类管理接口")
public class TvClassificationController extends BaseController<TvClassification, ITvClassificationService> {

}
