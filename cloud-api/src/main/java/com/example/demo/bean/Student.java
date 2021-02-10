package com.example.demo.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {

    public Student() {
    }

    public Student(Integer stuno, String stuname, String db) {
        this.stuno = stuno;
        this.stuname = stuname;
        this.db = db;
    }

    private static final long serialVersionUID = 1L;

    // 学号
    private Integer stuno ;
    // 姓名
    private String stuname ;
    // 微服务中可以存在很多数据库，用db指定对应的那个数据库
    private String db ;

}
