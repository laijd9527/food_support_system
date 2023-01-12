package com.ljd.food_support_sys.controller;

import com.ljd.food_support_sys.entity.FoodManager;
import com.ljd.food_support_sys.mapper.FoodManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/foodManager")
@CrossOrigin//允许跨域
public class FoodManagerController {
    @Autowired
    FoodManagerMapper foodManagerMapper;


    //查询所有食材管理员信息（已测）
    @RequestMapping("getAllManager")
    public Map getAllManager(){
        Map<String,Object> result=new HashMap<>();
        List<FoodManager> foodManagerList=foodManagerMapper.selectList(null);
        if (foodManagerList.isEmpty()){
            result.put("code","400");
            result.put("data"," ");
            result.put("msg","查询出错");
            return result;
        }else {
            result.put("code","200");
            result.put("data",foodManagerList);
            result.put("msg","成功");
            return result;
        }
    }
    //查询食材管理员数量（已测）
    @RequestMapping("getManagerCount")
    public Map getManagerCount(){
        Map<String,Object> result=new HashMap<>();
        List<FoodManager> foodManagers = foodManagerMapper.selectList(null);
        if (foodManagers.size()>=1){
            result.put("code","200");
            result.put("data",foodManagers.size());
            result.put("msg","查询成功");
            return result;
        }else {
            result.put("code","200");
            result.put("data"," ");
            result.put("msg","查询失败");
            return result;
        }
    }
    //根据食材管理员Id查询单条信息（已测）
    @RequestMapping("getManagerById")
    public Map getManagerById(@RequestBody FoodManager foodManager){
        Map<String,Object> result=new HashMap<>();
        FoodManager f =foodManagerMapper.selectById(foodManager.getFoodManagerId());
        if ( f == null){
            result.put("code",400);
            result.put("data"," ");
            result.put("msg","查询失败");
            return result;
        }else {
            result.put("code","200");
            result.put("data",f);
            result.put("msg","成功");
            return result;
        }
    }
    //新增食材管理员信息（已测）
    @RequestMapping("addManager")
    public Map addManager(@RequestBody FoodManager foodManager){
        Map<String,Object> result=new HashMap<>();
        int i = foodManagerMapper.insert(foodManager);
        if(i>=1){
            result.put("code",200);
            result.put("data",foodManager);
            result.put("msg","添加成功");
            return result;
        }else{
            result.put("code",400);
            result.put("data","");
            result.put("msg","添加失败");
            return result;
        }

    }
    //修改食材管理员信息（已测）
    @RequestMapping("updateManagerById")
    public Map updateManagerById(@RequestBody FoodManager foodManager){
        Map<String,Object> result=new HashMap<>();
        int i = foodManagerMapper.updateById(foodManager);
        if(i>=1){
            result.put("code",200);
            result.put("data",foodManager);
            result.put("msg","修改成功");
            return result;
        }else{
            result.put("code",400);
            result.put("data","");
            result.put("msg","修改失败");
            return result;
        }
    }
    //删除食材管理员信息（已测）
    @RequestMapping("deleteManagerById")
    public Map daleteManagerById(@RequestBody FoodManager foodManager){
        int i = foodManagerMapper.deleteById(foodManager.getFoodManagerId());
        Map<String,Object> result=new HashMap<>();
        if (i==0){
            result.put("code",200);
            result.put("data",i);
            result.put("msg","已删除");
            return result;
        }else {
            result.put("code",400);
            result.put("data"," ");
            result.put("msg","已删除");
            return result;
        }
    }


}
