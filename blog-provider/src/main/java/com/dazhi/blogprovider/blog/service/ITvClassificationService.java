package com.dazhi.blogprovider.blog.service;

import com.dazhi.blogprovider.blog.entity.TvClassification;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 视频分类 服务类
 * </p>
 *
 * @author dazhi
 * @since 2020-11-04
 */
public interface ITvClassificationService extends IService<TvClassification> {

    List<TvClassification> getWithDetailByLevel(Long themeId);
}
