package bittech;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

class Person1{
    String name;
    private Integer age;
    public char sex;

    private Person1(){}

    Person1(String name){
        this.name = name;
    }

    public Person1(String name, Integer age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public static void print(){
        System.out.println("This is Person static print");
    }

    private void print1(){
        System.out.println("This is Person private print1");
    }

    void print2(){
        System.out.println("This is Person print2");
    }
}

class Student extends Person1{
    private String ID;
    public Integer height;
    Double weight;

    private Student(String name){
        super(name);
    }

    Student(String name,Integer height,Double weight) {
        super(name);
        this.height = height;
        this.weight = weight;
    }

    public Student(String name, Integer age, char sex,String ID) {
        super(name, age, sex);
        this.ID = ID;
    }

    public static void display(){
        System.out.println("This is Student static display");
    }

    private void display1(){
        System.out.println("This is Student private display1");
    }

    void display2(){
        System.out.println("This is Student display2");
    }
}
public class Test {
    public static void main(String[] args) throws Exception{
        Student stu = new Student("lin",158,88.0);
//        Class<Student> cls = (Class<Student>) stu.getClass();
//        Class<Student> cls1 = Student.class;
//        Class<Student> cls2 = (Class<Student>) Class.forName("bittech.Student");
//        System.out.println(cls);
//        System.out.println(cls1);
//        System.out.println(cls2);
//        Class<Date> cls3 = Date.class;
//        System.out.println(cls3);
//        Date date = cls3.newInstance();
//        System.out.println(date);三种取得Class类对象的方法以及创建新对象
        Class<Student> cls = Student.class;
//        for(Constructor constructor:cls.getConstructors()){//取得本类中权限为public的构造方法
//            System.out.println(constructor);
//        }
//        System.out.println("-------------------------------");
//        for(Constructor constructor1:cls.getDeclaredConstructors()){//取得本类中所有权限的构造方法
//            System.out.println(constructor1);
//        }
//
//        for(Method method:cls.getMethods()){//取得本类和父类中权限为public的方法，包括普通方法
//            System.out.println(method);
//        }
//        System.out.println("----------------------------");
//        for(Method method1:cls.getDeclaredMethods()){//取得本类中所有权限的方法
//            System.out.println(method1);
//        }
//        for(Field field:cls.getFields()){//取得本类与父类中权限为public的属性
//            System.out.println(field);
//        }
//        System.out.println("----------------------------");
//        for(Field field1:cls.getDeclaredFields()){//取得本类中的所有属性
//            System.out.println(field1);
//        }
    }
}

