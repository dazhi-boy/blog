package com.dazhi.blogprovider.blog.controller;


import com.dazhi.blogprovider.blog.entity.Activity;
import com.dazhi.blogprovider.blog.entity.Attractions;
import com.dazhi.blogprovider.blog.service.IActivityService;
import com.dazhi.blogprovider.blog.service.IAttractionsService;
import com.dazhi.blogprovider.common.BaseController;
import com.dazhi.blogprovider.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @ApiOperation(value = "通过id获取entity和其明细")
    @GetMapping("/{id}/info")
    public Result<Activity> getWithDetail(@PathVariable("id") Long id) {
        IActivityService service = (IActivityService)this.iService;
        Activity activity = service.getByIdWithDetail(id);
        Result<Activity> result = Result.ok("OK");
        result.setData(activity);
        return result;
    }
}
