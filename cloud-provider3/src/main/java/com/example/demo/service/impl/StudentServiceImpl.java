package com.example.demo.service.impl;

import com.example.demo.bean.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public boolean addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    @Override
    public boolean deleteStudentByStuno(Integer stuno) {
        return studentMapper.deleteStudentByStuno(stuno);
    }

    @Override
    public boolean updateStudentByStuno(Student student) {
        return studentMapper.updateStudentByStuno(student);
    }

    @Override
    public List<Student> queryAllStudents() {
        return studentMapper.queryAllStudents();
    }
}
