package com.dazhi.blogprovider.blog.controller;


import com.dazhi.blogprovider.blog.entity.Attractions;
import com.dazhi.blogprovider.blog.entity.AttractionsDetail;
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
 * @since 2020-10-13
 */
@RestController
@RequestMapping("/blog/attractions")
@Api(value = "/base/attractions", tags = "AttractionsController", description = "景点管理接口")
public class AttractionsController extends BaseController<Attractions, IAttractionsService> {

    @Autowired
    IAttractionsDetailService detailService;

    @ApiOperation(value = "通过id获取entity和其明细")
    @GetMapping("/{id}/info")
    public Result<Attractions> getWithDetail(@PathVariable("id") Long id) {
        IAttractionsService service = (IAttractionsService)this.iService;
        Attractions attractions = service.getByIdWithDetail(id);
        Result<Attractions> result = Result.ok("OK");
        result.setData(attractions);
        return result;
    }

    @ApiOperation(value = "添加")
    @PostMapping
    public Result save(@RequestBody Attractions attractions) {
        boolean res = this.iService.save(attractions);
        List<AttractionsDetail> details = attractions.getAttractionsDetailList();
        for (AttractionsDetail detail : details){
            detail.setAttractionsId(attractions.getId());
            res = res && detailService.save(detail);
        }
        return Result.ok("OK", res);
    }
}
