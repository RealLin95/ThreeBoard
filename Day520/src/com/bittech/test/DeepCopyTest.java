package com.bittech.test;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;

class Person implements Serializable{
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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

    public Person(String name, int age) {

        this.name = name;
        this.age = age;
    }
}

class Worker implements Serializable{
    private Person person;
    private String ID;

    public Object deepClone() throws Exception{
        //通过内存进行序列化的写入与读取
        //写入
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        //读取
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }

    public Worker(Person person, String ID) {
        this.person = person;
        this.ID = ID;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "person=" + person +
                ", ID='" + ID + '\'' +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}

public class DeepCopyTest {
    public static void main(String[] args) throws Exception {
        Person person = new Person("lin",4);
        Worker workerA = new Worker(person,"001");
        Worker workerB = (Worker) workerA.deepClone();
        System.out.println(workerA);
        System.out.println(workerB);
        System.out.println(workerA.getPerson()==workerB.getPerson());
    }
}
