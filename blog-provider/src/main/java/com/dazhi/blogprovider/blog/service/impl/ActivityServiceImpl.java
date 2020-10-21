package com.dazhi.blogprovider.blog.service.impl;

import com.dazhi.blogprovider.blog.entity.Activity;
import com.dazhi.blogprovider.blog.mapper.ActivityMapper;
import com.dazhi.blogprovider.blog.service.IActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 景区列表 服务实现类
 * </p>
 *
 * @author dazhi
 * @since 2020-10-14
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements IActivityService {

    @Override
    public Activity getByIdWithDetail(Long id) {
        return this.baseMapper.getByIdWithDetail(id);
    }
}
