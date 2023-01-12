package com.ljd.food_support_sys.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ljd.food_support_sys.entity.Food;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface FoodMapper extends BaseMapper<Food> {
//    @Update("UPDATE food u\n" +
//            "SET \n" +
//            "`food_name`=#{foodName},\n" +
//            "`food_type`=#{foodType},\n" +
//            "`food_address`=#{foodAddress},\n" +
//            "`price`=#{price},\n" +
//            "`food_num`=#{foodNum},\n" +
//            "`quality_date`=#{qualityDate},\n" +
//            "`supply_name`=#{supplyName},\n" +
//            "`supply_address`=#{supplyAddress},\n" +
//            "`supply_phonenum`=#{supplyPhonenum},\n" +
//            "`supply_date`=#{supplyDate},\n" +
//            "`supplier_name`=#{supplierName},\n" +
//            "`supplier_phonenum`=#{supplierPhonenum},\n" +
//            "`supply_id`=#{supplyId},\n" +
//            "`supplier_id`=#{supplierId},\n" +
//            "`status`=#{status},\n" +
//            "`remarks`=#{remarks}\n" +
//            "WHERE u.food_id=#{foodId};")
//    void updateFoodById(Food food);

}
