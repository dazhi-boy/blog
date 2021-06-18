package com.dazhi.blogprovider.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dazhi.blogprovider.blog.entity.Activity;
import com.dazhi.blogprovider.blog.entity.TvClassification;
import com.dazhi.blogprovider.blog.service.IActivityService;
import com.dazhi.blogprovider.blog.service.ITvClassificationService;
import com.dazhi.blogprovider.common.BaseController;
import com.dazhi.blogprovider.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @ApiOperation(value = "通过id获取entity和其明细")
    @GetMapping("/{themeId}/list")
    public Result<List<TvClassification>> getWithDetailByLevel(@PathVariable("themeId") Long themeId) {
        ITvClassificationService service = (ITvClassificationService)this.iService;
        List<TvClassification> tvClassifications = service.getWithDetailByLevel(themeId);
        Result<List<TvClassification>> result = Result.ok("OK");
        result.setData(tvClassifications);
        return result;
    }

    @ApiOperation(value = "通过id获取entity和其明细")
    @GetMapping("/pid/{pid}")
    public Result<List<TvClassification>> getByPid(@PathVariable("pid") Long pid) {
        ITvClassificationService service = (ITvClassificationService)this.iService;
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("pid",pid);
        List<TvClassification> tvClassifications = service.list(queryWrapper);
        Result<List<TvClassification>> result = Result.ok("OK");
        result.setData(tvClassifications);
        return result;
    }
}
