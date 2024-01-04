package com.yang.cloud.common.stock.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yang.cloud.common.stock.result.Result;
import com.yang.cloud.common.stock.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CustomBlockExceptionHandler implements BlockExceptionHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, BlockException e) throws Exception {
        Result result;
        if (e instanceof FlowException) {
            result = Result.error(ResultCode.FLOW_ERROR);
        } else if (e instanceof DegradeException) {
            result = Result.error(ResultCode.DEGRADE_ERROR);
        } else {
            result = Result.error(ResultCode.BLOCK_ERROR);
        }
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(result));

    }
}
