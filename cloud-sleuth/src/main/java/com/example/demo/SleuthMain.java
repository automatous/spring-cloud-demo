package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SleuthMain {

    Logger logger = LoggerFactory.getLogger(SleuthMain.class);

    public static void main(String[] args) {
        SpringApplication.run(SleuthMain.class);
    }

    @RequestMapping("/hi")
    public String hi(@RequestParam(value = "name", defaultValue = "sleuth") String name) {
        logger.info("hi sleuth has been call....");
        return "hi hi~" + name;
    }
}
