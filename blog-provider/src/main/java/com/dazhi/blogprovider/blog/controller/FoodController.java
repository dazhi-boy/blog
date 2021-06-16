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

    @ApiOperation(value = "通过openId随机获取今日食谱")
    @GetMapping("/randGetFood/{openId}")
    public Result<List<Food>> randGetFood(@PathVariable("openId") String openId) {
        IFoodService service = (IFoodService)this.iService;
        List<Food> foods = service.listRandFood(openId);
        Result<List<Food>> result = Result.ok("OK");
        result.setData(foods);
        return result;
    }
    @ApiOperation(value = "通过openId随机获取今日食谱")
    @GetMapping("/randFood/{openId}/{type}")
    public Result<Food> randFood(@PathVariable("openId") String openId, @PathVariable("type") String type) {
        IFoodService service = (IFoodService)this.iService;
        Food food = service.listRandFood(openId, type);
        Result<Food> result = Result.ok("OK");
        result.setData(food);
        return result;
    }
}
