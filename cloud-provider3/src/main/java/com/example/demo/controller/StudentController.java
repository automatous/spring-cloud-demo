package com.example.demo.controller;

import com.example.demo.bean.Student;
import com.example.demo.service.StudentService;
import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Resource
    EurekaDiscoveryClient client;

    @RequestMapping("/discovery")
    public String discovery() {
        StringBuilder sb = new StringBuilder();
        List<String> services = client.getServices();
        services.forEach(t -> sb.append(client.getInstances(t)));
        return sb.toString();
    }

    @RequestMapping("/addStudent")
    public boolean addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @RequestMapping("/deleteStudentByStuno/{stuno}")
    public boolean deleteStudentByStuno(@PathVariable("stuno") Integer stuno) {
        return studentService.deleteStudentByStuno(stuno);
    }

    @RequestMapping("/updateStudentByStuno")
    public boolean updateStudentByStuno(@RequestBody Student student) {
        return studentService.updateStudentByStuno(student);
    }

    @RequestMapping("/queryAllStudents")
    public List<Student> queryAllStudents() {
        return studentService.queryAllStudents();
    }
}
