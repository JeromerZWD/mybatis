package com.dao;

import com.entity.Teacher;

public interface TeacherMapper {
    //根据教师id 查询所有信息
    Teacher findById(int id);
    //查询教师的所有学生
    Teacher findAllStudent(int id);
}
