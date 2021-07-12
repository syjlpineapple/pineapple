package com.example.promain.filter;

import cn.hutool.json.JSONUtil;
import com.example.promain.security.MyUserDetails;
import com.example.promain.utils.JWTUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @ClassName: AuthenticationFilter
 * @Description: 登录拦截器
 * @Author: zhilee
 * @Date: 2021/7/9 3:30 下午
 **/
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        super.setFilterProcessesUrl("/auth/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
            HttpServletResponse response) throws AuthenticationException {
        MyUserDetails myUserDetails = null;
        try {
            myUserDetails = new ObjectMapper().readValue(request.getInputStream(), MyUserDetails.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(myUserDetails.getUsername(),
                        myUserDetails.getPassword()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        MyUserDetails jwtUser = (MyUserDetails) authResult.getPrincipal();
        String token = JWTUtil.createToken(jwtUser.getUsername(), jwtUser.getRoles());
        // 返回创建成功的token
        System.out.println("success: token="+token);
        response.setContentType("application/json;charset=UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.setHeader("token", token);
    }

    /**
     * 验证失败
     * @param request
     * @param response
     * @param failed
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        Map<String,Object> responseMsg = new HashMap<>();
        responseMsg.put("1001","用户名或密码错误");
        response.getWriter().print(JSONUtil.toJsonStr(responseMsg));
    }
}