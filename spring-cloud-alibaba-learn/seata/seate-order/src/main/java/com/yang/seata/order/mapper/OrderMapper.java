package com.yang.seata.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yang.seata.order.entity.Order;

public interface OrderMapper extends BaseMapper<Order> {
    void create(Order order);
}
