package com.ljd.food_support_sys.controller;

import com.ljd.food_support_sys.entity.Supply;
import com.ljd.food_support_sys.mapper.SupplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/supply")
@CrossOrigin//允许跨域
public class SupplyController {

    @Autowired
    SupplyMapper supplyMapper;


    //查询所有供应商信息（已测）
    @RequestMapping("getAllSupply")
    public Map getAllSupply(){
        Map<String,Object> result=new HashMap<>();
        List<Supply> supplyList=supplyMapper.selectList(null);
        if (supplyList==null){
            result.put("code",400);
            result.put("data"," ");
            result.put("msg","查询失败");
            return result;
        }else {
            result.put("code",200);
            result.put("data",supplyList);
            result.put("msg","查询成功");
            return result;
        }
    }
    //根据供应商Id查询单条供应商信息（已测）
    @RequestMapping("getSupplyById")
    public Map getSupplyById(@RequestBody Supply supply){
        Map<String,Object> result=new HashMap<>();
        Supply s = supplyMapper.selectById(supply.getSupplyId());
        if (s==null){
            result.put("code",400);
            result.put("data",null);
            result.put("msg","查询失败");
            return result;
        }else {
            result.put("code","200");
            result.put("data", s);
            result.put("msg","成功");
            return result;
        }

    }
    //查询供应商数量（已测）
    @RequestMapping("getSupplyCount")
    public Map getSupplyCount(){
        Map<String,Object> result=new HashMap<>();
        Integer count = supplyMapper.selectCount(null);
        if (count==null){
            result.put("code",400);
            result.put("data"," ");
            result.put("msg","查询失败");
            return result;
        }else {
            result.put("code",200);
            result.put("data",count);
            result.put("msg","查询成功");
            return result;
        }
    }
    //新增供应商（已测）
    @RequestMapping("addSupply")
    public Map addSupply(@RequestBody Supply supply){
        Map<String,Object> result=new HashMap<>();
        int i = supplyMapper.insert(supply);
        if(i>=1){
            result.put("code",200);
            result.put("data",supply);
            result.put("msg","添加成功");
            return result;
        }else{
            result.put("code",400);
            result.put("data","");
            result.put("msg","添加失败");
            return result;
        }
    }
    //修改供应商信息（根据id）（已测）
    @RequestMapping("updateSupplyById")
    public Map updateSupplyById(@RequestBody Supply supply){
        Map<String,Object> result=new HashMap<>();
        int i = supplyMapper.updateById(supply);
        if(i>=1){
            result.put("code",200);
            result.put("data",supply);
            result.put("msg","修改成功");
            return result;
        }else{
            result.put("code",400);
            result.put("data"," ");
            result.put("msg","修改失败");
            return result;
        }

    }
    //删除供应商（根据id）（未测试）
    @RequestMapping("deleteSupplyById")
    public Map deleteSupplyById(@RequestBody Supply supply){
        Map<String,Object> result=new HashMap<>();
        int i = supplyMapper.deleteById(supply.getSupplyId());
        result.put("code",200);
        result.put("data",supply.getSupplyId());
        result.put("msg","已删除");
        return result;
    }

}
