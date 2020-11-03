package com.dazhi.baseprovider.base.controller;


import com.dazhi.baseprovider.base.entity.User;
import com.dazhi.baseprovider.base.service.IUserService;
import com.dazhi.baseprovider.common.BaseController;
import com.dazhi.baseprovider.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author dazhi
 * @since 2020-11-02
 */
@RestController
@RequestMapping("/base/user")
@Api(value = "/base/user", tags = "UserController", description = "用户管理接口")
public class UserController extends BaseController<User, IUserService> {

    @ApiOperation(value = "登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "秘密", dataType = "String")
    })
    @PostMapping("/login")
    public Result<User> login(String username, String password) {
        IUserService iUserService = (IUserService)this.iService;
        User user = iUserService.login(username,password);
        Result<User> result = Result.ok("ok");
        result.setData(user);
        return result;
    }
}
