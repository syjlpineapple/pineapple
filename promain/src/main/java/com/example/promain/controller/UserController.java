package com.example.promain.controller;


import com.example.promain.entity.User;
import com.example.promain.service.UserService;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhilee
 * @since 2021-06-26
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/save")
    public String save(@RequestBody User user) {
        return (userService.save(user) == true) ? "success" : "failed";
    }

    @RequestMapping("/login")
    public String login() {
        return null;
    }
}

