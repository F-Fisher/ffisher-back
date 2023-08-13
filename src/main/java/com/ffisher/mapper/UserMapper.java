package com.ffisher.mapper;

import com.ffisher.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    //根据用户名和密码查询用户
    @Select("select * from  user where username = #{username} and password = #{password}")
    User getByUserNameAndPassword(User user);
}
