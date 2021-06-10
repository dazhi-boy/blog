package com.dazhi.blogprovider.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dazhi.blogprovider.blog.entity.User;
import com.dazhi.blogprovider.blog.mapper.UserMapper;
import com.dazhi.blogprovider.blog.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author dazhi
 * @since 2020-11-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User login(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",username);
        return this.baseMapper.selectOne(queryWrapper);
    }
}
