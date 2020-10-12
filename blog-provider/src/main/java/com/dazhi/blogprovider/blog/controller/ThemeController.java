package com.dazhi.blogprovider.blog.controller;


import com.dazhi.blogprovider.blog.entity.Theme;
import com.dazhi.blogprovider.blog.service.IThemeService;
import com.dazhi.blogprovider.common.BaseController;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 主题表 前端控制器
 * </p>
 *
 * @author dazhi
 * @since 2020-10-12
 */
@RestController
@RequestMapping("/blog/theme")
@Api(value = "/base/theme", tags = "ThemeController", description = "主题管理接口")
public class ThemeController extends BaseController<Theme, IThemeService> {

}
