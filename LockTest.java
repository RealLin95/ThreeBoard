package com.bittech.test;

//生产者消费者模型

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Goods{
    private String name;
    private int maxSize;
    private int currentSize;
    private Lock lock = new ReentrantLock();
    //生产者等待队列
    private Condition producerQueue = lock.newCondition();
    //消费者等待队列
    private Condition consumerQueue = lock.newCondition();

    public Goods(int maxSize) {
        this.maxSize = maxSize;
    }

    public void setGoods(String name){
        try{
            lock.lock();
            while(this.currentSize==maxSize){
                System.out.println(Thread.currentThread().getName()+"商品已满，生产者等待...");
                producerQueue.await();
            }
            this.name = name;
            currentSize++;
            System.out.println(Thread.currentThread().getName()+"生产商品"+toString());
            consumerQueue.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", currentSize=" + currentSize +
                '}';
    }

    public void getGoods(){
        try{
            lock.lock();
            while(this.currentSize==0){
                System.out.println(Thread.currentThread().getName()+"商品已空，消费者等待...");
                consumerQueue.await();
            }
            currentSize--;
            System.out.println(Thread.currentThread().getName()+"消费商品"+toString());
            producerQueue.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            lock.unlock();
        }
    }
}

class Producers implements Runnable{
    private Goods goods;

    public Producers(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(2000);
                this.goods.setGoods("YSL");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumers implements Runnable{
    private Goods goods;

    public Consumers(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(2000);
                this.goods.getGoods();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class LockTest {
    public static void main(String[] args){
        List<Thread> list = new ArrayList<>();
        Goods goods = new Goods(10);
        Producers producers = new Producers(goods);
        Consumers consumers = new Consumers(goods);
        for(int i = 0;i<5;i++){
            list.add(new Thread(producers,"Producers-"+i));
        }
        for(int i = 0;i<10;i++){
            list.add(new Thread(consumers,"Consumers-"+i));
        }
        for(Thread thread:list){
            thread.start();
        }
    }
}
