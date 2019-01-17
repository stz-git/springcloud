package com.itmayiedu.web;

import com.itmayiedu.api.member.MemberAPI;
import com.itmayiedu.feign.MemberFeign;
import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope
public class OrderContrller {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MemberAPI memberAPI;

    @Autowired
    private MemberFeign memberFeign;

    @Value("${user.sex}")
    private String sex;

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
    @HystrixCommand(fallbackMethod = "memberFallback")
    @GetMapping("/testHystrix")
    public String member(String name) {
        System.out.println("request....ThreadPool："+Thread.currentThread().getName());
        String response = memberAPI.member(name);//Hystrix默认超时时间为1秒，此处熔断的原因是超时
        return response;
    }

    /**
     * 用于服务降级
     * @param name
     * @return
     */
    public String memberFallback(String name){
        return "Service degradation";
    }

    @GetMapping("/order3")
    public String member(){
        System.out.println("request....ThreadPool："+Thread.currentThread().getName());
        return "success:"+sex;
    }
}
