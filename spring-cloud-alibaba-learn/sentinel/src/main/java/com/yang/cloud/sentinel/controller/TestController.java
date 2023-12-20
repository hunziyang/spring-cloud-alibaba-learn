package com.yang.cloud.sentinel.controller;

import com.yang.cloud.common.stock.result.Result;
import com.yang.cloud.sentinel.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    private TestService testService;


    @GetMapping("/fast")
    public Result fast(){
        return Result.success("fast");
    }

    @GetMapping("/association")
    public Result association(){
        return Result.success("association");
    }

    @GetMapping("/limit")
    public Result limit(){
        System.out.println("limit");
        return Result.success("limit");
    }

    @GetMapping("/test1")
    public Result test1(){
        System.out.println("test1");
        return Result.success(testService.rand());
    }

    @GetMapping("/test2")
    public Result test2(){
        System.out.println("test2");
        testService.rand();
        System.out.println("test2end");
        return Result.success();
    }

    @GetMapping("/down")
    public Result down(){
        int i = 1/0;
        return Result.success();
    }

}
