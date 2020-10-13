package com.dazhi.blogprovider.blog.service;

import com.dazhi.blogprovider.blog.entity.Attractions;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 景区列表 服务类
 * </p>
 *
 * @author dazhi
 * @since 2020-10-13
 */
public interface IAttractionsService extends IService<Attractions> {
    public Attractions getByIdWithDetail(Long id);
}
