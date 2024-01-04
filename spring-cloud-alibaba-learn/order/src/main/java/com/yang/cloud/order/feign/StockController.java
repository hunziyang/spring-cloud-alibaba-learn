package com.yang.cloud.order.feign;


import com.yang.cloud.common.stock.entity.Stock;
import com.yang.cloud.common.stock.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * name:填服务名
 * path:填 Controller 上面的 RequestMapping 的 value 值
 */
@FeignClient(name = "stock",path = "/stock",fallback = StockControllerFallback.class)
public interface StockController {

    @GetMapping
    String stock();

    @GetMapping("/detail/{id}")
    Stock stockDetail(@PathVariable("id") Long id);

    @PostMapping
    Stock insert(@RequestBody Stock stock);

    @GetMapping("/err")
    Result err();
}
