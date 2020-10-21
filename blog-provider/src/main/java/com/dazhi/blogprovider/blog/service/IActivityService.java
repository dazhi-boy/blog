package com.dazhi.blogprovider.blog.service;

import com.dazhi.blogprovider.blog.entity.Activity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 景区列表 服务类
 * </p>
 *
 * @author dazhi
 * @since 2020-10-14
 */
public interface IActivityService extends IService<Activity> {

    public Activity getByIdWithDetail(Long id);
}
