package com.bittech.test;

import java.io.OutputStream;

class TestDemo{
    private int data;
    int result = 0;
    void m(){
        data += 2;
        result += 2;
        System.out.print(data+" "+result);
    }
}

class TestThread extends Thread{
    private TestDemo t;
    public TestThread(TestDemo t){
        this.t = t;
    }
    @Override
    public void run(){
        synchronized (t){
            t.m();
        }
    }
}

public class Test {
    public static void main(String[] args) {
//        System.out.println(Math.round(-11.5));
//        System.out.println(Math.round(11.5));
        TestDemo testDemo = new TestDemo();
        Thread thread1 = new TestThread(testDemo);
        Thread thread2 = new TestThread(testDemo);
        Thread thread3 = new TestThread(testDemo);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
