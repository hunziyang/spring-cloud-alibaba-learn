package com.yang.cloud.order.interceptor.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class CustomInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("yang","yang");
    }
}
