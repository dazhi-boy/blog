package com.dazhi.baseprovider.base.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dazhi.baseprovider.base.entity.User;
import com.dazhi.baseprovider.base.mapper.UserMapper;
import com.dazhi.baseprovider.base.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
