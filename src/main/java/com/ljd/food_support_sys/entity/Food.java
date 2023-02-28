package com.ljd.food_support_sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Food {
    //食材id
    @TableId("food_id")
    private Integer foodId;
    //食材名
    private String foodName;
    //食材种类
    private String foodType;
    //产地
    private String foodAddress;
    //单价
    private String price;
    //数量：斤
    private String foodNum;
    //保质期：天
    private String qualityDate;
    //供货商名
    private String supplyName;
    //供货商地址
    private String supplyAddress;
    //供货商电话
    private String supplyPhonenum;
    //供货日期
    //@JsonFormat(locale = "zh",timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date supplyDate;
    //供货人姓名
    private String supplierName;
    //供货人电话
    private String supplierPhonenum;
    //供货商Id
    private Integer supplyId;
    //供货人Id
    private Integer supplierId;
    //状态：0未审批、1已审批
    private String status;
    //备注
    private String remarks;

}
