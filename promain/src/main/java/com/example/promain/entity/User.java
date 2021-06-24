package com.example.promain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName: User
 * @Description: 用户类
 * @Author: zhilee
 * @Date: 2021/6/22 3:10 PM
 **/

@Data
@AllArgsConstructor
public class User {

    private Integer id;

    private String username;

    private String password;
}
