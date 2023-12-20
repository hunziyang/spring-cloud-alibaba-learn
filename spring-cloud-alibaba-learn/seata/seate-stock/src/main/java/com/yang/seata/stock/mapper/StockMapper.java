package com.yang.seata.stock.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yang.seata.stock.entity.Stock;
import org.apache.ibatis.annotations.Param;

public interface StockMapper extends BaseMapper<Stock> {


    void reduce(@Param("id") Long id);
}
