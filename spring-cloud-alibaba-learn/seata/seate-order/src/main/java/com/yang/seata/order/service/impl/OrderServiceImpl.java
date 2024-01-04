package com.yang.seata.order.service.impl;

import com.yang.seata.order.entity.Order;
import com.yang.seata.order.feign.FeignStockController;
import com.yang.seata.order.mapper.OrderMapper;
import com.yang.seata.order.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private FeignStockController feignStockController;

    @Override
    @GlobalTransactional
    public void create() {
        Order order = new Order().setPrice(10);
        orderMapper.create(order);
        feignStockController.reduce(1L);
    }
}
