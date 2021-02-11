package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConfigReadMain {
    public static void main(String[] args) {
        SpringApplication.run(ConfigReadMain.class);
    }

    @RequestMapping("/hi")
    public String hi(@RequestParam(value = "name", defaultValue = "read") String name) {
        return "hi hi~" + name;
    }
}
