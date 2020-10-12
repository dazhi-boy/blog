package com.dazhi.blogprovider.blog.service.impl;

import com.dazhi.blogprovider.blog.entity.Theme;
import com.dazhi.blogprovider.blog.mapper.ThemeMapper;
import com.dazhi.blogprovider.blog.service.IThemeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 主题表 服务实现类
 * </p>
 *
 * @author dazhi
 * @since 2020-10-12
 */
@Service
public class ThemeServiceImpl extends ServiceImpl<ThemeMapper, Theme> implements IThemeService {

}
