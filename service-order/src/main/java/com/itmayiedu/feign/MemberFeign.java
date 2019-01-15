package com.itmayiedu.feign;

import com.itmayiedu.api.member.MemberAPI;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "app-itmayiedu-member")
public interface MemberFeign{
}
