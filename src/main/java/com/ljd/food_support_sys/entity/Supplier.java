package com.ljd.food_support_sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Supplier {
    @TableId("supplier_id")
    private Integer supplierId;
    private String supplierName;
    private String sex;
    private String supplierPhonenum;
    private String supplyName;
    private int supplyId;
    private int userId;
    private String status;
    private String remarks;

}
