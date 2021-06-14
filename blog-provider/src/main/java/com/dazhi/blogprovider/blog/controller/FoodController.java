package com.dazhi.blogprovider.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dazhi.blogprovider.blog.entity.Food;
import com.dazhi.blogprovider.blog.service.IFoodService;
import com.dazhi.blogprovider.common.BaseController;
import com.dazhi.blogprovider.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * <p>
 * 美食列表 前端控制器
 * </p>
 *
 * @author dazhi
 * @since 2021-06-11
 */
@RestController
@RequestMapping("/blog/food")
@Api(value = "/blog/food", tags = "FoodController", description = "美食管理接口")
public class FoodController extends BaseController<Food, IFoodService> {

    @ApiOperation(value = "通过id获取entity和其明细")
    @PostMapping("/byParameter")
    public Result<List<Food>> getFoodByParameter(@RequestBody Food food) {
        IFoodService service = (IFoodService)this.iService;
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("open_id",food.getOpenId());
        wrapper.groupBy("type");
//        wrapper.apply("RAND()");

        List<Food> one = service.list(wrapper);

        Result<List<Food>> result = Result.ok("OK");
        result.setData(one);
        return result;
    }
}
