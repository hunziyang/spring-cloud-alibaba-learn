package com.yang.seata.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "seata-stock",path = "/stock")
public interface FeignStockController {

    @PutMapping("/reduce/{id}")
    void reduce(@PathVariable("id") Long id);
}
