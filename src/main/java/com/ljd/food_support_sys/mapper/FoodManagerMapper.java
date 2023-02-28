package com.ljd.food_support_sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ljd.food_support_sys.entity.FoodManager;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface FoodManagerMapper extends BaseMapper<FoodManager> {
//    @Select("selece * from food_manager where food_manager_id=#{foodManagerId}")
//    int selectManagerById(FoodManager foodManager);
    @Insert("INSERT INTO `food_manager` VALUES\n" +
            "(#{foodManagerId},#{foodManagerName},#{sex},\n"+
            "#{managerPhonenum},#{userId},#{userType},#{createTime},#{remarks});")
    int insertFoodManager(FoodManager foodManager);
}
