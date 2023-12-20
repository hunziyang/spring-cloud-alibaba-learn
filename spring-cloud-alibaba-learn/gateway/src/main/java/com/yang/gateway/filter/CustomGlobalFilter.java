package com.yang.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Component
@Order(1)
public class CustomGlobalFilter implements GlobalFilter {

    private static final String HEAD = "requestId";
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders headers = exchange.getRequest().getHeaders();
        ServerHttpResponse response = exchange.getResponse();
        String str = "err lllll yang";
        DataBuffer wrap = response.bufferFactory().wrap(str.getBytes(StandardCharsets.UTF_8));
        if (!headers.containsKey(HEAD)){
            return response.writeWith(Mono.just(wrap));
        }
        return chain.filter(exchange);
    }
}
