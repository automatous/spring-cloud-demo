package com.example.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "sleuth-cloud-hi")
public interface HiFeignClient {
    @RequestMapping("/hi")
    String hi(String name);
}
