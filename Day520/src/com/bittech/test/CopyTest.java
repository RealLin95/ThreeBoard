package com.bittech.test;

class Teacher{
    private String name;
    private String job;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Teacher(String name, String job) {
        this.name = name;
        this.job = job;
    }
}

class Student implements Cloneable{
    private Teacher teacher;
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "teacher=" + teacher +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
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

    public Student(Teacher teacher, String name, int age) {

        this.teacher = teacher;
        this.name = name;
        this.age = age;
    }
}

public class CopyTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Teacher teacher = new Teacher("yuisama", "Java");
        Student studentA = new Student(teacher, "lin", 4);
        Student studentB = (Student) studentA.clone();
        System.out.println(teacher);
        System.out.println(studentA);
        System.out.println(studentB);
        //不会产生新的引用对象，牵一发而动全身
        System.out.println(studentA.getTeacher()==studentB.getTeacher());
    }
}
