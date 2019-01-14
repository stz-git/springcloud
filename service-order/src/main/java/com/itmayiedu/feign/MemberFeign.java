package com.itmayiedu.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "app-itmayiedu-member")
public interface MemberFeign {

    @RequestMapping("/member")
    String member(@RequestParam("name")String name);
}
