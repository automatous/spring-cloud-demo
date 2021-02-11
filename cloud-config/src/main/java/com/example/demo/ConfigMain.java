package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableConfigServer
@RestController
public class ConfigMain {
    public static void main(String[] args) {
        SpringApplication.run(ConfigMain.class);
    }


    @RequestMapping("/hi")
    public String hi(@RequestParam(value = "name", defaultValue = "config") String name) {
        return "hi hi~" + name;
    }
}
