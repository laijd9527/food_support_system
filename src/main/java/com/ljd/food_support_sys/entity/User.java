package com.ljd.food_support_sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {
    @TableId("user_id")
    private Integer userId;
    private String userName;
    private String password;
    private String realName;
    private String phoneNumber;
    /*
    用户类型：1超管，2食材管理员，3供货员
    */
    private String userType;
}
