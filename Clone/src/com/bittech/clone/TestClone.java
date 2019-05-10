package com.bittech.clone;

import java.io.*;

public class TestClone {
    public static void easyClone() throws CloneNotSupportedException {
        Teacher teacher = new Teacher();
        teacher.setName("yuisama");
        teacher.setDirection("Java");
        Student studentA = new Student();
        studentA.setAge(21);
        studentA.setName("lin");
        studentA.setTeacher(teacher);
        Student studentB = (Student) studentA.clone();
        System.out.println(studentA);
        System.out.println(studentB);
        System.out.println(teacher);
        //修改Teacher属性
        studentB.getTeacher().setName("Peter");
        studentB.getTeacher().setDirection("C");
        //修改普通属性
        studentB.setName("meng");
        studentB.setAge(22);
        //对比输出
        //修改后的Teacher与studentB
        System.out.println("--------------------------------------------------------------------");
        System.out.println(studentA);
        System.out.println(studentB);
        System.out.println(teacher);
    }
    public static void main(String[] args) throws CloneNotSupportedException {
        //1.浅拷贝
        //TestClone.easyClone();

        //2.序列化实现深拷贝
        Teacher teacher = new Teacher();
        teacher.setName("yuisama");
        teacher.setDirection("Java");
        Student studentA = new Student();
        studentA.setAge(21);
        studentA.setName("lin");
        studentA.setTeacher(teacher);
        Student studentB = null;
        //序列化部分
        // studentA -> byte[] -> studentB
        try(ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream oout = new ObjectOutputStream(out)){
            oout.writeObject(studentA);
            byte[] data = out.toByteArray();
            try (ByteArrayInputStream in = new ByteArrayInputStream(data)) {
                try (ObjectInputStream oin = new ObjectInputStream(in)) {
                    studentB = (Student) oin.readObject();
                    System.out.println(studentA);
                    System.out.println(studentB);
                    System.out.println(teacher);
                    //修改属性后重新输出
                    studentB.getTeacher().setName("Peter");
                    studentB.getTeacher().setDirection("C");
                    studentB.setName("meng");
                    studentB.setAge(22);
                    //修改后的Teacher与studentB
                    System.out.println("--------------------------------------------------------------------");
                    System.out.println(studentA);
                    System.out.println(studentB);
                    System.out.println(teacher);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }catch(IOException e){

        }
    }
}
