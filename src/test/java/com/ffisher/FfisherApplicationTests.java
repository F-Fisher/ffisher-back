package com.ffisher;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class FfisherApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    public void testJwt(){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","ffisher");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "ffisher")//签名算法
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .compact();
        System.out.println(jwt);
    }
    @Test
    public void testParseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("ffisher")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiZmZpc2hlciIsImlkIjoxLCJleHAiOjE2ODk0Mjc0MzJ9.jgAdniK9MjJjNIDYjkFGPD96KH_vgATBuWdypnvECkA")
                .getBody();
        System.out.println(claims);


    }

}
