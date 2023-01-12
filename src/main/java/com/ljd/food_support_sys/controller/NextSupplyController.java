package com.ljd.food_support_sys.controller;


import com.ljd.food_support_sys.entity.NextSupply;
import com.ljd.food_support_sys.mapper.NextSupplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/nextSupply")
@CrossOrigin//允许跨域
public class NextSupplyController {

    @Autowired
    NextSupplyMapper nextSupplyMapper;

    //查询所有下次供货信息（未测试）
    @RequestMapping("getAllNextSupply")
    public Map getAllNextSupply(){
        Map<String,Object> result=new HashMap<>();
        List<NextSupply> nextSupplyList = nextSupplyMapper.selectList(null);
        if (nextSupplyList==null){
            result.put("code",400);
            result.put("data"," ");
            result.put("msg","查询失败");
            return result;
        }else {
            result.put("code",200);
            result.put("data",nextSupplyList);
            result.put("msg","查询成功");
            return result;
        }

    }
    //根据下次供货Id查询单条下次供货信息（未测试）
    @RequestMapping("getNextSupplyById")
    public Map getNextSupplyById(@RequestBody NextSupply nextSupply){
        Map<String,Object> result=new HashMap<>();
        NextSupply n = nextSupplyMapper.selectById(nextSupply.getNextSupplyId());
        if (n==null){
            result.put("code",400);
            result.put("data"," ");
            result.put("msg","查询失败");
            return result;
        }else {
            result.put("code",200);
            result.put("data",n);
            result.put("msg","查询成功");
            return result;
        }

    }
    //查询下次供货数量（未测试）
    @RequestMapping("getNextSupplyCount")
    public Map getNextSupplyCount(){
        Map<String,Object> result=new HashMap<>();
        Integer i = nextSupplyMapper.selectCount(null);
        if ( i == 0 ){
            result.put("code",400);
            result.put("data"," ");
            result.put("msg","查询失败");
            return result;
        }else {
            result.put("code",200);
            result.put("data",i);
            result.put("msg","查询成功");
            return result;
        }
    }
    //新增下次供货信息（未测试）
    @RequestMapping("addNextSupply")
    public Map addNextSupply(@RequestBody NextSupply nextSupply){
        Map<String,Object> result=new HashMap<>();
        int i = nextSupplyMapper.insert(nextSupply);
        if (i>=1){
            result.put("code",200);
            result.put("data",i);
            result.put("msg","已新增下次供货信息");
            return result;
        }else {
            result.put("code",400);
            result.put("data"," ");
            result.put("msg","新增失败");
            return result;
        }

    }
    //修改下次供货信息（根据id）（未测试）
    @RequestMapping("updateNextSupply")
    public Map updateNextSupply(@RequestBody NextSupply nextSupply){
        Map<String,Object> result=new HashMap<>();
        int i = nextSupplyMapper.updateById(nextSupply);
        if ( i == 1 ){
            result.put("code",200);
            result.put("data",nextSupply);
            result.put("msg","已修改下次供货信息");
            return result;
        }else {
            result.put("code",400);
            result.put("data"," ");
            result.put("msg","修改失败");
            return result;
        }

    }
    //删除下次供货记录（根据id）（已测）
    @RequestMapping("deleteNextSupplyById")
    public Map deleteNextSupplyById(@RequestBody NextSupply nextSupply){
        Map<String,Object> result=new HashMap<>();
        int i = nextSupplyMapper.deleteById(nextSupply.getNextSupplyId());
        if ( i == 1 ){
            result.put("code",200);
            result.put("data",nextSupply.getNextSupplyId());
            result.put("msg","删除成功");
            return result;
        }else {
            result.put("code",400);
            result.put("data"," ");
            result.put("msg","删除信息失败");
            return result;
        }

    }


}
