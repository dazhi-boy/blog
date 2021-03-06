package com.dazhi.blogprovider.blog.service.impl;

import com.dazhi.blogprovider.blog.entity.Attractions;
import com.dazhi.blogprovider.blog.entity.AttractionsDetail;
import com.dazhi.blogprovider.blog.mapper.AttractionsDetailMapper;
import com.dazhi.blogprovider.blog.mapper.AttractionsMapper;
import com.dazhi.blogprovider.blog.service.IAttractionsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 景区列表 服务实现类
 * </p>
 *
 * @author dazhi
 * @since 2020-10-13
 */
@Service
public class AttractionsServiceImpl extends ServiceImpl<AttractionsMapper, Attractions> implements IAttractionsService {

    @Override
    public Attractions getByIdWithDetail(Long id) {
        return this.baseMapper.getByIdWithDetail(id);
    }
}
