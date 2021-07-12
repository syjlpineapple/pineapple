package com.example.promain.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: CurrentAuthentation
 * @Description: 测试类-获取当前用户的Authentication
 * @Author: YYY
 * @Date: 2021/6/10 14:17
 **/
@RestController
public class CurrentAuthentication {
    @GetMapping(value={"","/"})
    public Authentication get() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
