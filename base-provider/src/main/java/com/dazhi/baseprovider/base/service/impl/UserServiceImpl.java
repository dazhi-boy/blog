package com.dazhi.baseprovider.base.service.impl;

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
 * @since 2020-10-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
