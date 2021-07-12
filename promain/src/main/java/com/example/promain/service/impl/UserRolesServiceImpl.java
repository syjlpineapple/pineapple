package com.example.promain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.promain.entity.UserRoles;
import com.example.promain.mapper.UserRolesMapper;
import com.example.promain.security.MyUserDetails;
import com.example.promain.service.UserRolesService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhilee
 * @since 2021-06-26
 */
@Service
public class UserRolesServiceImpl extends ServiceImpl<UserRolesMapper, UserRoles> implements UserRolesService {

    @Resource
    private UserRolesMapper userRolesMapper;

    @Override
    public MyUserDetails getByUsername(String username) {
        return userRolesMapper.getByUsername(username);
    }
}
