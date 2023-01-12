package com.ljd.food_support_sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ljd.food_support_sys.entity.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface SupplierMapper extends BaseMapper<Supplier> {

}
