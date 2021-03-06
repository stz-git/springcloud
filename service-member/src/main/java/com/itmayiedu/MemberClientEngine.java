package com.itmayiedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MemberClientEngine {
    public static void main(String[] args) {
        SpringApplication.run(MemberClientEngine.class,args);
    }
}
