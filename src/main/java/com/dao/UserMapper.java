package com.dao;

import com.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User findById(int id);
    List<User> findAll();
    void deleteUser(int id);
    void updateUser(User user);
    void saveUser(User user);
    List<User> logincheck(User user);
    User findUserByIdResultMap(int id);
    List<User> selectName(String username);
    List<User> findByIds(@Param("ids") List<Integer>ids);
    List<User> findByIds2(@Param("ids") List<Integer>ids);
    //批量插入
    int addUsers(@Param("users") List<User>users);
}
