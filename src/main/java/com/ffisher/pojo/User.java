package com.ffisher.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
// user 实体类

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer uid;//uid
    private String username;//登录用户名
    private String password;//登录密码
    private  String name;// 昵称
    private Integer exp;//经验值
    private  Integer age;//年龄
    private  Short gender;//性别 0未知 1男 2女
    private  Short  leve;//等级、0管理员 1user
    private  String image;//头像
    private LocalDateTime createTime;//创建事件
    private LocalDateTime updateTime;//修改事件
}
