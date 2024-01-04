package com.yang.gateway.predicate;

import lombok.Data;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * 1、类必须是Spring组件 Bean
 *
 * 2、类必须加上RoutePredicateFactory作为结尾
 *
 * 3、类必须继承AbstractRoutePredicateFactory
 *
 * 4、类必须声明静态内部类，声明属性来接收配置文件中对应的断言的信息
 *
 * 5、需要结合shortcutFieldOrder进行绑定
 *
 * 6、通过apply进行逻辑判断，true：配置成功，false：配置失败
 */
@Component
public class CustomRoutePredicateFactory extends AbstractRoutePredicateFactory<CustomRoutePredicateFactory.Config> {

    public CustomRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return serverWebExchange -> {
            MultiValueMap<String, String> queryParams = serverWebExchange.getRequest().getQueryParams();
            if (!queryParams.containsKey(config.name)){
                return false;
            }
            if (!Pattern.matches(config.value,queryParams.get(config.name).get(0))){
                return false;
            }
            return true;
        };

    }

    /**
     * 参数映射
     * @return
     */
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("name","value");
    }

    @Data
    public static class Config{

        private String value;
        private String name;
    }
}
