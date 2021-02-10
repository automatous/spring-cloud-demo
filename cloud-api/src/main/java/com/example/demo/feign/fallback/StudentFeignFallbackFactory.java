package com.example.demo.feign.fallback;

import com.example.demo.bean.Student;
import com.example.demo.feign.StudentFeign;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentFeignFallbackFactory implements FallbackFactory<StudentFeign> {
    @Override
    public StudentFeign create(Throwable cause) {
        return new StudentFeign() {
            @Override
            public boolean addStudent(Student student) {
                System.out.println("add fail....");
                return false;
            }

            @Override
            public boolean deleteStudentByStuno(Integer stuno) {
                System.out.println("delete fail....");
                return false;
            }

            @Override
            public boolean updateStudentByStuno(Student student) {
                System.out.println("update fail....");
                return false;
            }

            @Override
            public List<Student> queryAllStudents() {
                List<Student> ret = new ArrayList<>();
                ret.add(new Student(0, "no feign stunames", "no feign databases"));
                return ret;
            }
        };
    }
}
