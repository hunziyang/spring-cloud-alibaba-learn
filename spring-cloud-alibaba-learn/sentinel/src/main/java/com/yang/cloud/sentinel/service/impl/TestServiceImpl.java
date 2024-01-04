package com.yang.cloud.sentinel.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.yang.cloud.sentinel.service.TestService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class TestServiceImpl implements TestService {
    @Override
    @SentinelResource(value = "rand")
    public String rand() {
        return String.valueOf(new Random().nextInt(15));
    }
}
