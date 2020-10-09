package com.dazhi.blogprovider.blog.controller;


import com.dazhi.blogprovider.blog.entity.User;
import com.dazhi.blogprovider.blog.service.IUserService;
import com.dazhi.blogprovider.common.BaseController;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author dazhi
 * @since 2020-10-09
 */
@RestController
@RequestMapping("/base/user")
@Api(value = "/base/user", tags = "UserController", description = "用户管理接口")
public class UserController extends BaseController<User,IUserService> {
}
