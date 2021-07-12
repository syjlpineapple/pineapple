package com.example.promain;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.promain.entity.User;
import com.example.promain.service.UserService;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName: UserServiceTest
 * @Description: 单元测试类
 * @Author: zhilee
 * @Date: 2021/7/8 2:54 下午
 **/

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PromainApplication.class)
public class UserServiceTest {
    @Resource
    private UserService userService;

    @Test
    public void getUser(){
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, "zhilee");
        User user = userService.getOne(queryWrapper);
        System.out.println(user);
    }
}
