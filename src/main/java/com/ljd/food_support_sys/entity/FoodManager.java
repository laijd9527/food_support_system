package com.ljd.food_support_sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class FoodManager {
    @TableId("food_manager_id")
    private Integer foodManagerId;
    @TableField("food_manager_name")
    private String foodManagerName;
    private String sex;
    private String managerPhonenum;
    private Integer userId;
    private String userType;
    //@JsonFormat(locale = "zh",timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String remarks;

}
