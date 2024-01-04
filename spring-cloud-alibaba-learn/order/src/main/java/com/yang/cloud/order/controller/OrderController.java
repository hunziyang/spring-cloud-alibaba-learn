package com.yang.cloud.order.controller;

import com.yang.cloud.common.stock.entity.Stock;
import com.yang.cloud.common.stock.result.Result;
import com.yang.cloud.order.feign.StockController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

//    @Autowired
//    private RestOperations stockRestOperation;

    @Autowired
    private StockController stockController;

    @GetMapping
    public void order(){
        System.out.println("order 创建完成");
//        ResponseEntity<String> forEntity = stockRestOperation.getForEntity("/stock", String.class);
//        String body = forEntity.getBody();
        String stock = stockController.stock();
        System.out.println("welcome"+stock);

    }

    @GetMapping("/detail")
    public void detail(){
        System.out.println("detail");
        Stock stock = stockController.stockDetail(1L);
        System.out.println(stock);
    }

    @GetMapping("/insert")
    public void insert(){
        Stock stock = new Stock()
                .setStock(154L)
                .setName("插入");
        Stock insert = stockController.insert(stock);
        System.out.println(insert);
    }

    @GetMapping("/err")
    public void err(){
        Result err = stockController.err();
        System.out.println(err);
    }
}
