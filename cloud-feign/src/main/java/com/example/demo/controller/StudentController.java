package com.example.demo.controller;

import com.example.demo.bean.Student;
import com.example.demo.feign.StudentFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feign/student")
public class StudentController {
    @Autowired
    StudentFeign studentFeign;

    @RequestMapping("/addStudent")
    public boolean addStudent(Student student) {
        return studentFeign.addStudent(student);
    }

    @RequestMapping("/deleteStudentByStuno/{stuno}")
    public boolean deleteStudentByStuno(@PathVariable("stuno") Integer stuno) {
        return studentFeign.deleteStudentByStuno(stuno);
    }

    @RequestMapping("/updateStudentByStuno")
    public boolean updateStudentByStuno(Student student) {
        return studentFeign.updateStudentByStuno(student);
    }

    @RequestMapping("/queryAllStudents")
    public List<Student> queryAllStudents() {
        return studentFeign.queryAllStudents();
    }
}
