package com.xino.service;

import com.xino.dao.mybatis.bean.Student;


import java.util.List;


public interface UserService {

    List<Student> list();
    Student get(Integer id);
    Student save(Student user);
    Student update(Student user);
    void delete(Integer id);

}
