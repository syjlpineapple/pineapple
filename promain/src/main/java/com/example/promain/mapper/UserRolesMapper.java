package com.example.promain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.promain.entity.UserRoles;
import com.example.promain.security.MyUserDetails;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhilee
 * @since 2021-06-26
 */
public interface UserRolesMapper extends BaseMapper<UserRoles> {

    MyUserDetails getByUsername(@Param("username") String username);
}
