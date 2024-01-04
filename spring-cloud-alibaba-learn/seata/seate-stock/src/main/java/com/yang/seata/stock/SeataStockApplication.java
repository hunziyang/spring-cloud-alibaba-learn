package com.yang.seata.stock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.yang.seata.stock.mapper")
@EnableTransactionManagement
public class SeataStockApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataStockApplication.class, args);
    }
}
