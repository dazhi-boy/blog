package com.dazhi.blogprovider.blog.controller;


import com.dazhi.blogprovider.blog.entity.TutorialTv;
import com.dazhi.blogprovider.blog.service.ITutorialTvService;
import com.dazhi.blogprovider.common.BaseController;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 教学视频 前端控制器
 * </p>
 *
 * @author dazhi
 * @since 2020-11-02
 */
@RestController
@RequestMapping("/blog/tutorial-tv")
@Api(value = "/blog/tutorial-tv", tags = "TutorialTvController", description = "视频教程管理接口")
public class TutorialTvController extends BaseController<TutorialTv, ITutorialTvService> {

}
