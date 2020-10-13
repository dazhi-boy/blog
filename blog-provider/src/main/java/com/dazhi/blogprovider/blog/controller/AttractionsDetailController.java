package com.dazhi.blogprovider.blog.controller;


import com.dazhi.blogprovider.blog.entity.AttractionsDetail;
import com.dazhi.blogprovider.blog.service.IAttractionsDetailService;
import com.dazhi.blogprovider.common.BaseController;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 景区图文介绍 前端控制器
 * </p>
 *
 * @author dazhi
 * @since 2020-10-13
 */
@RestController
@RequestMapping("/blog/attractions-detail")
@Api(value = "/base/attractions-detail", tags = "AttractionsDetailController", description = "景点明细管理接口")
public class AttractionsDetailController extends BaseController<AttractionsDetail, IAttractionsDetailService> {

}
