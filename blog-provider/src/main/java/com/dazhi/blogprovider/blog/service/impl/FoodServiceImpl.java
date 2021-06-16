package com.dazhi.blogprovider.blog.service.impl;

import com.dazhi.blogprovider.blog.entity.Food;
import com.dazhi.blogprovider.blog.mapper.FoodMapper;
import com.dazhi.blogprovider.blog.service.IFoodService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 美食列表 服务实现类
 * </p>
 *
 * @author dazhi
 * @since 2021-06-11
 */
@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food> implements IFoodService {

    @Override
    public List<Food> listRandFood(String openId) {
        List<Food> foods = this.baseMapper.listRandFood(openId);
        if (foods.size() == 0){
            foods = this.baseMapper.listRandFood(null);
        }
        return foods;
    }

    @Override
    public Food listRandFood(String openId, String type) {
        Food food = this.baseMapper.randFood(openId, type);
        if (null == food) {
            food = this.baseMapper.randFood(null, type);
        }
        return food;
    }
}
