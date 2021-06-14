package com.dazhi.blogprovider.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dazhi.blogprovider.blog.entity.User;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author dazhi
 * @since 2020-11-02
 */
public interface IUserService extends IService<User> {

    User login(String username, String password);
}
