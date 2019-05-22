package com.bittech.test;

import java.util.concurrent.Exchanger;

public class ExchangerTest {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        Thread girl = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String str = exchanger.exchange("I like you...");
                    System.out.println("女生说:"+str);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        girl.start();

        Thread boy = new Thread(new Runnable() {
            @Override
            public void run() {
                String str = null;
                try {
                    Thread.sleep(1000);
                    str = exchanger.exchange("I love you!!!");
                    System.out.println("男生说:"+str);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        boy.start();
    }
}
