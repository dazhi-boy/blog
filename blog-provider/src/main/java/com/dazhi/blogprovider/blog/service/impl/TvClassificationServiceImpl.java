package com.dazhi.blogprovider.blog.service.impl;

import com.dazhi.blogprovider.blog.entity.TvClassification;
import com.dazhi.blogprovider.blog.mapper.TvClassificationMapper;
import com.dazhi.blogprovider.blog.service.ITvClassificationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 视频分类 服务实现类
 * </p>
 *
 * @author dazhi
 * @since 2020-11-04
 */
@Service
public class TvClassificationServiceImpl extends ServiceImpl<TvClassificationMapper, TvClassification> implements ITvClassificationService {

    @Override
    public List<TvClassification> getWithDetailByLevel(Long level) {
        return this.baseMapper.getWithDetailByLevel(level);
    }
}
