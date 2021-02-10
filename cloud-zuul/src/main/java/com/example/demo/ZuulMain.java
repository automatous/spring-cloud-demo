package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableZuulProxy
@EnableDiscoveryClient
@EnableHystrix
public class ZuulMain {

    Logger logger = LoggerFactory.getLogger(ZuulMain.class);

    public static void main(String[] args) {
        SpringApplication.run(ZuulMain.class);
    }

    @RequestMapping("/hi")
    public String hi(@RequestParam(value = "name", defaultValue = "zuul") String name) {
        logger.info("hi zuul has been call....");
        return "hi hi~" + name;
    }
}
