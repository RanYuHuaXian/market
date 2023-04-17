package org.example;

import test2.ClassAnno;
import test2.FieldAnno;

import java.io.*;
import java.lang.reflect.Field;
import java.util.HashMap;

public class myIOC {
    public static void main(String[] args) throws Exception {
        //1.通过IO流读取文件中的内容——获取类的路径
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/org/example/bean.txt"));
        String data="";//表示用于存储读取到的文件中的每行内容
        //申明一个HashMap用于存储对象
        HashMap<String, Object> map = new HashMap<>();

        while((data=br.readLine())!=null){
//            System.out.println(data);
            //2.通过反射 创建类的字节码对象——》创建类的对象
            Class<?> c = Class.forName(data);

            //获取类上的注解中的注解type属性值，true创建对象，false不创建
            ClassAnno anno = c.getAnnotation(ClassAnno.class);//获取类上的ClassAnno注解
            //获取type值
//            System.out.println(anno.type());

            if(anno.type()){
                //3.创建类的对象
                Object o = c.newInstance();
                //4.存放到HashMap  getSimpleName()获取类的名称作为key值
                map.put(c.getSimpleName(),o);
            }

        }
        //5.根据名字获取对象
        Student stu=(Student)map.get("Student");
        System.out.println(stu);


        //获取fieldAnno注解的值
        Class<?> ca = Class.forName("org.example.Student");
        Field f = ca.getDeclaredField("name");
        Field a = ca.getDeclaredField("age");
        FieldAnno field = f.getAnnotation(FieldAnno.class);
        FieldAnno fage = a.getAnnotation(FieldAnno.class);
        System.out.println(field.name());
        System.out.println(fage.age());

    }
}
