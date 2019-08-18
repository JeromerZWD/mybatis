package com.entity;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private int id;
    private String name;
    private Classes classes;
    private List<Student> students=new ArrayList<>();


    public Teacher(int id, String name, Classes classes) {
        this.id = id;
        this.name = name;
        this.classes = classes;
    }

    public Teacher(int id, String name, Classes classes, List<Student> students) {
        this.id = id;
        this.name = name;
        this.classes = classes;
        this.students = students;
    }

    public Teacher() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

/*    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classes=" + classes +
                '}';
    }*/

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classes=" + classes +
                ", students=" + students +
                '}';
    }
}
