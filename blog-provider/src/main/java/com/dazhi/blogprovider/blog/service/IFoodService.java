package com.dazhi.blogprovider.blog.service;

import com.dazhi.blogprovider.blog.entity.Food;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 美食列表 服务类
 * </p>
 *
 * @author dazhi
 * @since 2021-06-11
 */
public interface IFoodService extends IService<Food> {

    List<Food> listRandFood(String openId);

    Food listRandFood(String openId, String type);
}
