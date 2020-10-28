package com.dazhi.blogprovider.blog.controller;


import com.dazhi.blogprovider.blog.entity.Activity;
import com.dazhi.blogprovider.blog.entity.ActivityDetail;
import com.dazhi.blogprovider.blog.entity.Attractions;
import com.dazhi.blogprovider.blog.entity.AttractionsDetail;
import com.dazhi.blogprovider.blog.service.IActivityDetailService;
import com.dazhi.blogprovider.blog.service.IActivityService;
import com.dazhi.blogprovider.blog.service.IAttractionsDetailService;
import com.dazhi.blogprovider.blog.service.IAttractionsService;
import com.dazhi.blogprovider.common.BaseController;
import com.dazhi.blogprovider.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    IActivityDetailService detailService;

    @ApiOperation(value = "通过id获取entity和其明细")
    @GetMapping("/{id}/info")
    public Result<Activity> getWithDetail(@PathVariable("id") Long id) {
        IActivityService service = (IActivityService)this.iService;
        Activity activity = service.getByIdWithDetail(id);
        Result<Activity> result = Result.ok("OK");
        result.setData(activity);
        return result;
    }

    @ApiOperation(value = "添加")
    @PostMapping
    public Result save(@RequestBody Activity activity) {
        boolean res = this.iService.save(activity);
        List<ActivityDetail> details = activity.getDetails();
        for (ActivityDetail detail : details){
            detail.setActivityId(activity.getId());
            res = res && detailService.save(detail);
        }
        return Result.ok("OK", res);
    }
}
