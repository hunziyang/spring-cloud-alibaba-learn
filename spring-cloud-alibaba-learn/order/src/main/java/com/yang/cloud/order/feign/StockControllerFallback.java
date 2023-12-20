package com.yang.cloud.order.feign;

import com.yang.cloud.common.stock.entity.Stock;
import com.yang.cloud.common.stock.result.Result;
import org.springframework.stereotype.Component;

@Component
public class StockControllerFallback implements StockController{
    @Override
    public String stock() {
        return null;
    }

    @Override
    public Stock stockDetail(Long id) {
        return null;
    }

    @Override
    public Stock insert(Stock stock) {
        return null;
    }

    @Override
    public Result err() {
        return Result.success("err了");
    }
}
