package com.ljd.food_support_sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class NextSupply {
    @TableId("next_supply_id")
    private Integer nextSupplyId;
    @JsonFormat(locale = "zh",timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date nextDate;
    private String supplyName;
    private String supplyAddress;
    private String supplyPhonenum;
    private String supplierName;
    private String supplierPhonenum;
    private String foodName;
    private String foodType;
    private String foodAddress;
    private String price;
    private String foodNum;
    private String qualityDate;
    private Integer supplyId;
    private Integer supplierId;
    private String status;
    private String remarks;
}
