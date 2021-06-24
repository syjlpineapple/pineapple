package com.example.promain.utils;

import com.example.promain.entity.User;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName: JWTUtil
 * @Description: JWT工具类
 * @Author: zhilee
 * @Date: 2021/6/22 3:03 PM
 **/
public class JWTUtil {
    /**
     * 创建token
     * @param user 用户信息
     * @param ttlMillis 过期时间
     * @return
     */
    public static String createJwt(User user,long ttlMillis) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("id", user.getId());
        claims.put("username",user.getUsername());
        // claims.put("password",user.getPassword());

        String key = user.getPassword();
        String subject = user.getUsername();

        long currentMillis = System.currentTimeMillis();
        JwtBuilder builder = Jwts.builder().setClaims(claims).setId(UUID.randomUUID().toString())
                .setIssuedAt(new Date(currentMillis)).setSubject(subject).signWith(signatureAlgorithm,key);

        if (ttlMillis > 0) {
            long expireMillis = currentMillis + ttlMillis;
            builder.setExpiration(new Date(expireMillis));
        }
        return builder.compact();
    }
}
