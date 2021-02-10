package com.example.demo.service;

import com.example.demo.bean.Student;

import java.util.List;

public interface StudentService {
    boolean addStudent(Student student);

    boolean deleteStudentByStuno(Integer stuno);

    boolean updateStudentByStuno(Student student);

    List<Student> queryAllStudents();
}
