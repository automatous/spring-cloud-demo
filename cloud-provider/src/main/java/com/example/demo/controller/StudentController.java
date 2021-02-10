package com.example.demo.controller;

import com.example.demo.bean.Student;
import com.example.demo.service.StudentService;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.util.CollectionUtils;
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

//    @RequestMapping("/queryAllStudents")
//    public List<Student> queryAllStudents() {
//        List<Student> ret = studentService.queryAllStudents();
//        if (CollectionUtils.isEmpty(ret)) {
//            throw new RuntimeException("no students");
//        }
//        return ret;
//    }


    @RequestMapping("/queryAllStudents")
    @HystrixCommand(fallbackMethod = "hystrixQueryAllStudents")
    public List<Student> queryAllStudents() {
        List<Student> ret = studentService.queryAllStudents();
        if (CollectionUtils.isEmpty(ret)) {
            throw new RuntimeException("no students");
        }
        return ret;
    }

    // 熔断保护方法(备用方法)
    public List<Student> hystrixQueryAllStudents() {
        List<Student> stus = studentService.queryAllStudents();
        stus.add(new Student(0, "no controller students", "no controller databases"));
        return stus;
    }
}
