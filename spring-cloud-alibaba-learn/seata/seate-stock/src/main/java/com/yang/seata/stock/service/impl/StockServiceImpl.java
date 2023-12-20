package com.yang.seata.stock.service.impl;

import com.yang.seata.stock.mapper.StockMapper;
import com.yang.seata.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockMapper stockMapper;
    @Override
    @Transactional
    public void reduce(Long id) {
        stockMapper.reduce(id);
    }
}
