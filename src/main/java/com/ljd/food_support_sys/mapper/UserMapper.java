package com.ljd.food_support_sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ljd.food_support_sys.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper extends BaseMapper<User> {
//    @Delete("DELETE FROM user WHERE user_id=#{userId}")
//    int deleteByUserId(User user);


}
