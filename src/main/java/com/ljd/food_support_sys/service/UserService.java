package com.ljd.food_support_sys.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljd.food_support_sys.entity.User;
import com.ljd.food_support_sys.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper,User> {

}
