package com.entity;

/**
 * @author Mr Wu
 * @create: 2019-08-09 17:27
 */
public class Student {

    private Integer id;

    private String name;

    /**
     * 一对多 一的一方
     * */
    private Classes classes;

    public Student() {

    }

    public Student(Integer id, String name, Classes classes) {
        this.id = id;
        this.name = name;
        this.classes = classes;
    }

    public Student(Integer id, String name) {

        this.id = id;
        this.name = name;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

 /*   @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '}';
    }*/

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classes=" + classes +
                '}';
    }
}
