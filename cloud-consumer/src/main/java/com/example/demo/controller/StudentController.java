package com.example.demo.controller;

import com.example.demo.bean.Student;
import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/consumer/student")
public class StudentController {
//    private static final String URL_PREFIX = "http://localhost:8888/student";
    private static final String URL_PREFIX = "http://cloud-provider/student";
//    private static final String URL_PREFIX = "cloud-provider/student";

    @Autowired
    RestTemplate restTemplate;

//    @Resource
//    DiscoveryClient discoveryClient;

    @Resource
    EurekaDiscoveryClient client;


    @RequestMapping("/discovery")
    public String discovery() {
        StringBuilder sb = new StringBuilder();
//        Set<String> allKnownRegions = discoveryClient.getAllKnownRegions();
        List<String> services = client.getServices();
        services.forEach(t -> sb.append(client.getInstances(t)));
        return sb.toString();
    }

    @RequestMapping("/addStudent")
    public Boolean addStudent(Student student) {
        ResponseEntity<Boolean> responseEntity = restTemplate.postForEntity(URL_PREFIX + "/addStudent", student, Boolean.class);
        return responseEntity.getBody();
    }

    @RequestMapping("/deleteStudentByStuno/{stuno}")
    public Boolean deleteStudentByStuno(@PathVariable("stuno") Integer stuno) {
        Boolean object = restTemplate.getForObject(URL_PREFIX + "/deleteStudentByStuno/" + stuno, Boolean.class);
        return object;
    }

    @RequestMapping("/updateStudentByStuno")
    public Boolean updateStudentByStuno(Student student) {
        Boolean object = restTemplate.postForObject(URL_PREFIX + "/updateStudentByStuno", student, Boolean.class);
        return object;
    }

    @RequestMapping("/queryAllStudents")
    public List<Student> queryAllStudents() {
//        List list = restTemplate.getForObject(URL_PREFIX + "/queryAllStudents", List.class);    // 这里的泛型解决不了!
        List<Student> list = restTemplate.getForObject(URL_PREFIX + "/queryAllStudents", (Class<List<Student>>) ((Class) List.class));  // 只能容忍报黄警告了
        return list;
    }
}
