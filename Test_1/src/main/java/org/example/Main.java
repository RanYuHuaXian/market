package org.example;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws Exception {

//        System.out.println("Hello world!");
        //正面访问
        Student stu = new Student("张三",18);

//        通过反射方式创建对象（1）
        //获取学生类的Class字节码对象
        Class<?> c = Class.forName("org.example.Student");
        //(2)创建学生对象
        Student stu2 = (Student)c.newInstance();
        //(3)通过反射获取到类的成员变量——>获取filed[](存储学生类的成员变量)
        Field[] fields = c.getFields();
        //遍历
        //快捷键 fields.for
        for (Field field : fields) {
            //获取到成员变量名称
            System.out.println(field.getName());
        }
        System.out.println("-------------------------------------");
        //获取全部成员变量（包括私有变量）
        Field[] declaredFields = c.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println(f.getName());
        }
        System.out.println("-------------------------------------");
        //获取指定成员变量
        Field name = c.getDeclaredField("name");
        System.out.println(name);

    }
}