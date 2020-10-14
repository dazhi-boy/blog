package com.dazhi.blogprovider.blog.controller;


import com.dazhi.blogprovider.blog.entity.Activity;
import com.dazhi.blogprovider.blog.service.IActivityService;
import com.dazhi.blogprovider.common.BaseController;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 景区列表 前端控制器
 * </p>
 *
 * @author dazhi
 * @since 2020-10-14
 */
@RestController
@RequestMapping("/blog/activity")
@Api(value = "/base/activity", tags = "ActivityController", description = "活动管理接口")
public class ActivityController extends BaseController<Activity, IActivityService> {

}
