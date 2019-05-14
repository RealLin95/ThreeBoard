package com.bittech.test;

import java.lang.reflect.Field;

class Teacher{
    private String name;
    private Integer age;
    private String skill;

    public Teacher(String name, Integer age, String skill) {
        this.name = name;
        this.age = age;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", skill='" + skill + '\'' +
                '}';
    }
}

class Student{
    private String name;
    private Integer age;
    private String ID;

    public Student(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", ID='" + ID + '\'' +
                '}';
    }
}

//将源对象中与目标对象中一样的属性值拿出来赋给目标对象

public class BeanCopy {

    public static void copy(Object source,Object target){
        if(source==null||target==null){
            throw new IllegalArgumentException("Parameter source or target must be not null!");
        }
        Class sourceClass = source.getClass();
        Class targetClass = target.getClass();
        Field[] sourceFields = sourceClass.getDeclaredFields();
        Field[] targetFields = targetClass.getDeclaredFields();
        for(Field s :sourceFields){
            for(Field t:targetFields){
                if(s.getName().equals(t.getName())){
                    s.setAccessible(true);
                    t.setAccessible(true);
                    try {
                        Object value = s.get(source);
                        t.set(target,value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Teacher teacher = new Teacher("Miss Zhang",25,"Java");
        Student student = new Student();
        BeanCopy.copy(teacher,student);
        System.out.println(teacher);
        System.out.println(student);
    }
}
