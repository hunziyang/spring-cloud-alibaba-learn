package com.yang.cloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 若当前配置类写在 ComponentScan 能够扫描到的位置，那么将对所有 RibbonClient 生效，即全局配置生效
 */
@Configuration
public class RibbonRandomRule {

    @Bean
    public IRule iRule(){
        return new RandomRule();
    }
}
