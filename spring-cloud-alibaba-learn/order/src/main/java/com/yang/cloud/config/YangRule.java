package com.yang.cloud.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class YangRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        ILoadBalancer loadBalancer = getLoadBalancer();
        List<Server> reachableServers = loadBalancer.getReachableServers(); //仅限已启动且可访问的服务器
        List<Server> allServers = loadBalancer.getAllServers();

        return reachableServers.stream().findFirst().orElse(null);
    }
}
