package com.example.promain.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.promain.entity.User;
import com.example.promain.entity.UserRoles;
import com.example.promain.security.MyUserDetails;
import com.example.promain.service.UserRolesService;
import com.example.promain.service.UserService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @ClassName: MyUserDetailService
 * @Description: UserDeatils实现类
 * @Author: zhilee
 * @Date: 2021/7/8 11:18 上午
 **/
@Service
public class MyUserDetailService implements UserDetailsService {

    @Resource
    private UserService userService;

    @Resource
    private UserRolesService userRolesService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRolesService.getByUsername(s);
    }
}
