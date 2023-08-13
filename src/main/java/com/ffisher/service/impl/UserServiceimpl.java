package com.ffisher.service.impl;

import com.ffisher.mapper.UserMapper;
import com.ffisher.pojo.User;
import com.ffisher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(User user) {
        return userMapper.getByUserNameAndPassword(user);
    }
}
