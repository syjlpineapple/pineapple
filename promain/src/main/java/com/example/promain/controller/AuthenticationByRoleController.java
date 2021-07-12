package com.example.promain.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: AuthenticationByRoleController
 * @Description: 测试-根据角色控制用户权限
 * @Author: zhilee
 * @Date: 2021/6/11 9:48
 **/
@RestController
public class AuthenticationByRoleController {
    @GetMapping("/auth")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Authentication auth() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @GetMapping("/home")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public String home() {
        return "HOME";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String user() {
        return "USER";
    }
}
