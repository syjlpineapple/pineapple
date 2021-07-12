package com.example.promain.security;

import com.example.promain.filter.AuthenticationFilter;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName: SecurityConfig
 * @Description: 自定义WebSecurity配置
 * @Author: zhilee
 * @Date: 2021/6/10 14:41
 **/
@EnableWebSecurity
// 这个注解，可以开启security的注解，我们可以在需要控制权限的方法上面使用@PreAuthorize、@PreFilter这些注解。
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("index.html","/css/**", "/fonts/**", "/js/**", "/plugins/**", "/images/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http.csrf().disable();   //使用csrf功能
        http.authorizeRequests().antMatchers("/login/**")
                .permitAll().anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/main")
                .and()
                .addFilter(new AuthenticationFilter(authenticationManager()))
                .exceptionHandling()
                .and().logout().logoutSuccessUrl("/login?logout");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123"));
    }
}
