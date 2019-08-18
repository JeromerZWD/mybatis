package com.dao;

import com.entity.Classes;

public interface ClassesMapper {
    //根据班级id 查询所有信息
    Classes findById(int id);
    //查询班级的所有学生
    Classes findAllStudent(int id);
}
