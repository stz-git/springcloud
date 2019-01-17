package com.itmayiedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import sun.security.krb5.Config;
@SpringBootApplication
@EnableConfigServer
public class ConfigServerEngine {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerEngine.class,args);
    }
}
