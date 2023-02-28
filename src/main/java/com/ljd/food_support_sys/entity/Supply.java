package com.ljd.food_support_sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Supply {
    @TableId("supply_id")
    private Integer supplyId;
    private String supplyName;
    private String supplyAddress;
    private String supplyPhonenum;
    //@JsonFormat(locale = "zh",timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date openTime;

    private Integer supplierId;
    private String supplierName;
    //@JsonFormat(locale = "zh",timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String status;
    private String remarks;

}
