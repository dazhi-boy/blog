package com.dazhi.baseprovider.base.service;

import com.dazhi.baseprovider.base.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

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
