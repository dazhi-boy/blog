package com.dazhi.blogprovider.blog.service.impl;

import com.dazhi.blogprovider.blog.entity.Food;
import com.dazhi.blogprovider.blog.mapper.FoodMapper;
import com.dazhi.blogprovider.blog.service.IFoodService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
