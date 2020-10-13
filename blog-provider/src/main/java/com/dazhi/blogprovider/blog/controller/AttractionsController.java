package com.dazhi.blogprovider.blog.controller;


import com.dazhi.blogprovider.blog.entity.Attractions;
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
 * @since 2020-10-13
 */
@RestController
@RequestMapping("/blog/attractions")
@Api(value = "/base/attractions", tags = "AttractionsController", description = "景点管理接口")
public class AttractionsController extends BaseController<Attractions, IAttractionsService> {

    @ApiOperation(value = "通过id获取entity和其明细")
    @GetMapping("/{id}/info")
    public Result<Attractions> getWithDetail(@PathVariable("id") Long id) {
        IAttractionsService service = (IAttractionsService)this.iService;
        Attractions attractions = service.getByIdWithDetail(id);
        Result<Attractions> result = Result.ok("OK");
        result.setData(attractions);
        return result;
    }
}
