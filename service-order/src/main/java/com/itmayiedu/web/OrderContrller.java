package com.itmayiedu.web;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OrderContrller {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/order")
    public String index(String name){
        String requestURL = "http://APP-ITMAYIEDU-MEMBER/member?name={name}";
//        String requestURL = "http://192.168.13.45:8081/member?name={name}";

        /*Map<String, Object> params = new HashMap<>();
        params.put("name", "tianyu");*/

        String response = restTemplate.getForObject(requestURL,String.class,name);
        return response;
    }
}
