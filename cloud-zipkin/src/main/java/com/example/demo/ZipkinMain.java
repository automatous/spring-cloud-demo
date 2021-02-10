package com.example.demo;

import com.example.demo.feign.HiFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.example.demo.feign"})
public class ZipkinMain {

    Logger logger = LoggerFactory.getLogger(ZipkinMain.class);

    @Resource
    HiFeignClient hiFeignClient;

    public static void main(String[] args) {
        SpringApplication.run(ZipkinMain.class);
    }

    @RequestMapping("/hi")
    public String hi(@RequestParam(value = "name", defaultValue = "zipkin") String name) {
        logger.info("hi......................................");
        return "zipkin hi~" + name;
    }

    @RequestMapping("/hiFeign")
    public String hiFeign(@RequestParam(value = "name", defaultValue = "zipkin-feign") String name) {
        logger.info("hiFeign......................................");
        String hi = hiFeignClient.hi(name);
        return "zipkin hiFeign~" + name + " <==> " + hi;
    }
}
