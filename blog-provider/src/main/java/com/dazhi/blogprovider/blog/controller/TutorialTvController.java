package com.dazhi.blogprovider.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dazhi.blogprovider.blog.entity.TutorialTv;
import com.dazhi.blogprovider.blog.entity.TvClassification;
import com.dazhi.blogprovider.blog.service.ITutorialTvService;
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

    @ApiOperation(value = "通过id获取entity和其明细")
    @GetMapping("/pid/{pid}")
    public Result<List<TutorialTv>> getByPid(@PathVariable("pid") Long pid) {
        ITutorialTvService service = (ITutorialTvService)this.iService;
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("pid",pid);
        List<TutorialTv> tutorialTv = service.list(queryWrapper);
        Result<List<TutorialTv>> result = Result.ok("OK");
        result.setData(tutorialTv);
        return result;
    }
}
