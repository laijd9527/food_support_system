package com.ljd.food_support_sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ljd.food_support_sys.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper extends BaseMapper<User> {
//    @Delete("DELETE FROM user WHERE user_id=#{userId}")
//    int deleteByUserId(User user);
    @Select("SELECT * FROM user where user_name=#{userName} and password=#{password}")
    User login(@Param("userName") String userName,@Param("password") String password);

    //判断用户类型
    @Select("select user_type from `user` u where user_name=#{userName}")
    User userType(@Param("userName")String userName);

    @Select("select user_type from user where user_id=#{userId}")
    List<User> getUserRole(Integer userId);

//    User selectOne(@Param("realName") String realName);

}
