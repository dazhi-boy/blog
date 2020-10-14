package com.dazhi.blogprovider.blog.controller;


import com.dazhi.blogprovider.blog.entity.ActivityDetail;
import com.dazhi.blogprovider.blog.service.IActivityDetailService;
import com.dazhi.blogprovider.common.BaseController;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 活动图文介绍 前端控制器
 * </p>
 *
 * @author dazhi
 * @since 2020-10-14
 */
@RestController
@RequestMapping("/blog/activity-detail")
@Api(value = "/base/activity-detail", tags = "ActivityDetailController", description = "活动明细管理接口")
public class ActivityDetailController extends BaseController<ActivityDetail, IActivityDetailService> {

}
