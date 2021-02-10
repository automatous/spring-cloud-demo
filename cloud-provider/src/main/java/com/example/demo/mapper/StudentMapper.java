package com.example.demo.mapper;

import com.example.demo.bean.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    boolean addStudent(Student student);

    boolean deleteStudentByStuno(Integer stuno);

    boolean updateStudentByStuno(Student student);

    List<Student> queryAllStudents();
}
