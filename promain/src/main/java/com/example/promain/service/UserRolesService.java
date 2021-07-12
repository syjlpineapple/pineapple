package com.example.promain.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.promain.entity.UserRoles;
import com.example.promain.security.MyUserDetails;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhilee
 * @since 2021-06-26
 */
public interface UserRolesService extends IService<UserRoles> {

    /**
     * 工具用户名查询
     * @param username
     * @return
     */
    MyUserDetails getByUsername(String username);
}
