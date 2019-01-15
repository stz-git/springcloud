package com.itmayiedu.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 模拟高并发ServletContainer崩溃情况（Tomcat线程池被占满）
 */
@RestController
public class MemberController {

    private Integer count = 0;

    @Value("${server.port}")
    private String port;

    @GetMapping("/member")
    public String index(String name) throws Exception{
        System.out.println(count++);
        try{
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "member";
    }

    @GetMapping("/member2")
    public String index2(){
        return "member2: success";
    }
}
