package com.itmayiedu.web;

import com.itmayiedu.api.member.MemberAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderContrller {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MemberAPI memberAPI;

    @GetMapping("/order")
    public String index(String name){
        String requestURL = "http://APP-ITMAYIEDU-MEMBER/member?name={name}";
//        String requestURL = "http://192.168.13.45:8081/member?name={name}";

        /*Map<String, Object> params = new HashMap<>();
        params.put("name", "tianyu");*/

        String response = restTemplate.getForObject(requestURL,String.class,name);
        return response;
    }

    /**
     * 使用feign组件远程调用
     * @param name
     * @return
     */
    @GetMapping("/order2")
    public String member(String name){
        String response = memberAPI.member(name);
        return response;
    }
}
