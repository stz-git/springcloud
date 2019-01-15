package com.itmayiedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrderClientEngine{
    public static void main(String[] args) {
        SpringApplication.run(OrderClientEngine.class,args);
    }

    @Bean
    @LoadBalanced//基于ribbon实现远程调用的本地负载均衡
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}