package com.dazhi.word.core.controller;


import com.dazhi.word.common.BaseController;
import com.dazhi.word.core.entity.Theme;
import com.dazhi.word.core.service.IThemeService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 主题表 前端控制器
 * </p>
 *
 * @author dazhi
 * @since 2020-12-02
 */
@RestController
@RequestMapping("/core/theme")
@Api(value = "/core/theme", tags = "ThemeController", description = "主题管理接口")
public class ThemeController extends BaseController<Theme, IThemeService> {

}
