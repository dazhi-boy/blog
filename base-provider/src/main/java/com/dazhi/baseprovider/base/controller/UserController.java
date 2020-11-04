package com.dazhi.baseprovider.base.controller;


import com.dazhi.baseprovider.base.entity.User;
import com.dazhi.baseprovider.base.service.IUserService;
import com.dazhi.baseprovider.common.BaseController;
import com.dazhi.baseprovider.common.Result;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

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
    @PostMapping("/login")
    public Result<User> login(@RequestBody LoginUser loginUser) {
        IUserService iUserService = (IUserService)this.iService;
        User user = iUserService.login(loginUser.username,loginUser.password);
        Result<User> result = Result.ok("ok");
        result.setData(user);
        return result;
    }
}

@ApiModel(value="LoginUser对象", description="用户登录信息")
class LoginUser {
    @ApiModelProperty(value = "账号")
    public String username;
    @ApiModelProperty(value = "密码")
    public String password;
}
