package com.yang.seata.stock.controller;

import com.yang.seata.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @PutMapping("/reduce/{id}")
    public void reduce(@PathVariable("id") Long id){
        stockService.reduce(id);
    }
}
