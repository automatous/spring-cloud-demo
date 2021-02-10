package com.example.demo.feign;

import com.example.demo.bean.Student;
import com.example.demo.feign.fallback.StudentFeignFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "cloud-provider/student", fallbackFactory = StudentFeignFallbackFactory.class)
@Component
public interface StudentFeign {
    @RequestMapping("/addStudent")
    boolean addStudent(Student student);

    @RequestMapping("/deleteStudentByStuno/{stuno}")
    boolean deleteStudentByStuno(@PathVariable("stuno") Integer stuno);

    @RequestMapping("/updateStudentByStuno")
    boolean updateStudentByStuno(Student student);

    @RequestMapping("/queryAllStudents")
    List<Student> queryAllStudents();
}
