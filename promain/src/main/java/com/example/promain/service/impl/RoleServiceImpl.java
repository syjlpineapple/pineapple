package com.example.promain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.promain.entity.Role;
import com.example.promain.mapper.RoleMapper;
import com.example.promain.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author zhilee
 * @since 2021-06-26
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
