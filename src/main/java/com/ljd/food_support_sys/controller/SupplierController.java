package com.ljd.food_support_sys.controller;


import com.ljd.food_support_sys.entity.Supplier;
import com.ljd.food_support_sys.mapper.SupplierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/supplier")
@CrossOrigin//允许跨域
public class SupplierController {

    @Autowired
    SupplierMapper supplierMapper;

    //查询所有供货人信息（未测试）
    @RequestMapping("getAllSupplier")
    public Map getAllSupplier(){
        Map<String,Object> result=new HashMap<>();
        List<Supplier> supplierList=supplierMapper.selectList(null);
        if (supplierList==null){
            result.put("code",400);
            result.put("data"," ");
            result.put("msg","查询失败");
            return result;
        }else {
            result.put("code",200);
            result.put("data",supplierList);
            result.put("msg","查询成功");
            return result;
        }

    }
    //根据供货人Id查询单条供货人信息（未测试）
    @RequestMapping("getSupplierById")
    public Map getSupplierById(@RequestBody Supplier supplier){
        Map<String,Object> result=new HashMap<>();
        Supplier s = supplierMapper.selectById(supplier.getSupplierId());
        if ( s != null){
            result.put("code",200);
            result.put("data",s);
            result.put("msg","查询成功");
            return result;
        }else {
            result.put("code",200);
            result.put("data"," ");
            result.put("msg","查询失败！");
            return result;
        }


    }
    //查询供货人数量（未测试）
    @RequestMapping("getSupplierCount")
    public Map getSupplierCount(){
        Map<String,Object> result=new HashMap<>();
        Integer count = supplierMapper.selectCount(null);
        if (count>=1){
            result.put("code",200);
            result.put("data",count);
            result.put("msg","查询成功");
            return result;
        }else {
            result.put("code",400);
            result.put("data"," ");
            result.put("msg","查询失败！");
            return result;
        }
    }
    //新增供货人（未测试）
    @RequestMapping("addSupplier")
    public Map addSupplier(@RequestBody Supplier supplier){
        Map<String,Object> result=new HashMap<>();
        int i = supplierMapper.insert(supplier);
        if(i>=1){
            result.put("code",200);
            result.put("data",i);
            result.put("msg","添加成功");
            return result;
        }else{
            result.put("code",400);
            result.put("data","");
            result.put("msg","添加失败");
            return result;
        }
    }
    //修改供货人（根据id）（未测试）
    @RequestMapping("updateSupplier")
    public Map updateSupplier(@RequestBody Supplier supplier){
        Map<String,Object> result=new HashMap<>();
        int i = supplierMapper.updateById(supplier);
        if(i>=1){
            result.put("code",200);
            result.put("data",i);
            result.put("msg","修改成功");
            return result;
        }else{
            result.put("code",400);
            result.put("data","");
            result.put("msg","修改失败");
            return result;
        }

    }
    //删除供货人（根据id）（未测试）
    @RequestMapping("deleteSupplier")
    public Map deleteSupplier(@RequestBody Supplier supplier){
        Map<String,Object> result=new HashMap<>();
        int i = supplierMapper.deleteById(supplier.getSupplierId());
        result.put("code",200);
        result.put("data",i);
        result.put("msg","已删除");
        return result;
    }

}
