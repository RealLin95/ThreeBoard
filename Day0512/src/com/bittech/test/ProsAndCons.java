package com.bittech.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;
import java.util.Scanner;

public class ProsAndCons {
    //通过手动配置参数及创建线程
    public static void code1() {
        //商品容器
        final Queue<Goods> queue = new LinkedList<>();
        final Integer maxGoods = 10;

        //生产者与消费者
        final Producer producer = new Producer(queue,maxGoods, 1000L);
        final Consumer consumer = new Consumer(queue, 2500L);

        //单线程进行业务处理
//        Thread producerThread1 = new Thread(producer,"生产者-1");
//        Thread consumerThread1 = new Thread(consumer,"消费者-1");
//        producerThread1.start();
//        consumerThread1.start();

        //多线程版本
        for(int i=0;i<5;i++){
            new Thread(producer,"Thread-Producer-"+i).start();
        }
        for(int i=0;i<8;i++){
            new Thread(consumer,"Thread-Consumer-"+i).start();
        }
    }

    //通过控制台的接收用户键盘输入设置线程数量等参数
    public static void code2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入容量大小：");
        final Integer maxGoods = scanner.nextInt();

        System.out.println("请输入生产者数量：");
        final Integer producers = scanner.nextInt();
        System.out.println("请输入生产速率(ms)：");
        final long producerSpeed = scanner.nextLong();

        System.out.println("请输入消费者数量：");
        final Integer consumers = scanner.nextInt();
        System.out.println("请输入消费速率(ms)：");
        final long consumerSpeed = scanner.nextLong();

        final Queue<Goods> queue = new LinkedList<>();
        final Producer producer = new Producer(queue,maxGoods,producerSpeed);
        final Consumer consumer = new Consumer(queue,consumerSpeed);

        for(int i =0;i<producers;i++){
            new Thread(producer,"Thread-Procuder-"+i).start();
        }
        for(int i=0;i<consumers;i++){
            new Thread(consumer,"Thread-Consumer-"+i).start();
        }
    }

    //通过外部配置文件读取
    public static void code3() {
        Properties properties = new Properties();
        try(InputStream in =
                    ProsAndCons.class.getClassLoader().
                getResourceAsStream("ProAndCon_init.properties")){
            properties.load(in);
        }catch(IOException e){

        }
        final Integer maxGoods = Integer.parseInt
                (properties.getProperty("collect.max_capacity"));
        final Integer producers = Integer.parseInt
                (properties.getProperty("producer.number"));
        final long producerSpeed = Long.parseLong
                (properties.getProperty("producer.speed"));
        final Integer consumers = Integer.parseInt
                (properties.getProperty("consumer.number"));
        final long consumerSpeed = Long.parseLong
                (properties.getProperty("consumer.speed"));
        final Queue<Goods> queue = new LinkedList<>();
        final Producer producer = new Producer(queue,maxGoods,producerSpeed);
        final Consumer consumer = new Consumer(queue,consumerSpeed);

        for(int i =0;i<producers;i++){
            new Thread(producer,"Thread-Procuder-"+i).start();
        }
        for(int i=0;i<consumers;i++){
            new Thread(consumer,"Thread-Consumer-"+i).start();
        }
    }

    public static void main(String[] args) {
        Properties properties = new Properties();
        try(InputStream in = ProsAndCons.class.getClassLoader().
                            getResourceAsStream("ProAndCon_init.properties")){
        properties.load(in);
        }catch(IOException e){

        }
        Manager manager = new Manager(properties);
        manager.startProducer();
        manager.startConsumer();
        System.out.println(manager.getCurrentInfo());
    }
}
