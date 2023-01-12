package com.ljd.food_support_sys.controller;

import com.ljd.food_support_sys.entity.Food;
import com.ljd.food_support_sys.mapper.FoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/food")
@CrossOrigin//允许跨域
public class FoodController {
    @Autowired
    FoodMapper foodMapper;


    //查询所有食材信息（已测）
    @RequestMapping("getAllFood")
    public Map getAllFood(){
        Map<String,Object> result=new HashMap<>();
        List<Food> foods = foodMapper.selectList(null);
        if (foods.isEmpty()){
            result.put("code",400);
            result.put("data"," ");
            result.put("msg","查询结果异常");
            return result;
        }else {
            result.put("code",200);
            result.put("data",foods);
            result.put("msg","查询成功");
            return result;
        }
    }
    //根据食材id查询单条食材信息（已测）
    @RequestMapping("getFoodById")
    public Map getFoodById(@RequestBody Food food){
        Map<String,Object> result=new HashMap<>();
        Food f =foodMapper.selectById(food.getFoodId());
        if ( f == null){
            return null;
        }
        result.put("code",200);
        result.put("data",f);
        result.put("msg","查询成功");
        return result;

    }
    //查询食材数量（已测）
    @RequestMapping("getFoodCount")
    public Map getFoodCount(){
        Map<String,Object> result=new HashMap<>();
        List<Food> foods =foodMapper.selectList(null);
        if (foods.isEmpty()){
            result.put("code",400);
            result.put("data"," ");
            result.put("msg","查询结果异常");
            return result;
        }else {
            result.put("code",200);
            result.put("data",foods.size());
            result.put("msg","查询成功");
            return result;
        }

    }
    //新增食材信息（已测）
    @RequestMapping("addFood")
    public Map addFood(@RequestBody Food food){
        int i = foodMapper.insert(food);
        Map<String,Object> result=new HashMap<>();
        if(i>=1){
            result.put("code",200);
            result.put("data","");
            result.put("msg","添加成功");
            return result;
        }else{
            result.put("code",400);
            result.put("data","");
            result.put("msg","添加失败");
            return result;
        }
    }
    //根据Id修改食材信息（已测）
    @RequestMapping("updateFoodById")
    public Map updateFood(@RequestBody Food food){
        Map<String,Object> result=new HashMap<>();
        int i =foodMapper.updateById(food);
        if (i>=1){
            result.put("code",200);
            result.put("data",food);
            result.put("msg","修改成功");
            return result;
        }else {
            result.put("code",400);
            result.put("data"," ");
            result.put("msg","失败！");
            return result;
        }

    }
    //删除食材信息（根据id）（已测）
    @RequestMapping("deleteFoodById")
    public Map deleteFoodById(@RequestBody Food food){
        int i = foodMapper.deleteById(food.getFoodId());
        Map<String,Object> result=new HashMap<>();
        result.put("code",200);
        result.put("data"," ");
        result.put("msg","已删除");
        return result;

    }

}
