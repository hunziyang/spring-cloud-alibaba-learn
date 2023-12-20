package com.yang.cloud.stock.controller;

import com.yang.cloud.common.stock.entity.Stock;
import com.yang.cloud.common.stock.result.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Value("${server.port}")
    private String port;


    @GetMapping
    public String stock(){
        System.out.println("stock 库存调用成功");
        return port;
    }

    @GetMapping("/detail/{id}")
    public Stock stockDetail(@PathVariable("id") Long id){
        return new Stock()
                .setId(id)
                .setStock(50L)
                .setName("测试");
    }

    @PostMapping
    public Stock insert(@RequestBody Stock stock){
        stock.setId(2L);
        return stock;
    }

    @GetMapping("/err")
    public Result err(){
        int i = 1/0;
        return Result.success("异常成功");
    }
}
