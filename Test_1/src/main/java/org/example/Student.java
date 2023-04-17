package org.example;

import test2.ClassAnno;
import test2.FieldAnno;

@ClassAnno(type = true,name = "test")
public class Student {
    @FieldAnno(name="wangwu")
    public String name;
    @FieldAnno(age=18)
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
