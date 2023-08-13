package com.ffisher.controller;

import com.ffisher.pojo.Result;
import com.ffisher.pojo.User;
import com.ffisher.service.UserService;
import com.ffisher.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        log.info("登录{}",user);
        User e =  userService.login(user);
        if(e!=null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("uid",e.getUid());
            claims.put("username",e.getUsername());
            claims.put("password",e.getPassword());
            log.info("---------{}",claims.toString());
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }
}
