package bittech;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Good{
    private int maxCount;
    private String name;
    private int count;
    private Lock lock = new ReentrantLock();
    private Condition producerCondition = lock.newCondition();
    private Condition consumerCondition = lock.newCondition();

    public Good(int maxCount) {
        this.maxCount = maxCount;
    }

    public void setGoods(String name){
        lock.lock();
        try {
            while (count == maxCount) {
                System.out.println(Thread.currentThread().getName()+"商品已达到最大值");
                try {
                    producerCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.name = name;
            count++;
            System.out.println(Thread.currentThread().getName()+"生产"+toString());
            consumerCondition.signalAll();
        } finally{
            lock.unlock();
        }
    }

    public void getGood(){
        lock.lock();
        try{
            while(count==0){
                System.out.println(Thread.currentThread().getName()+"商品卖完了");
                try {
                    consumerCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count--;
            System.out.println(Thread.currentThread().getName()+"消费"+toString());
            producerCondition.signalAll();
        }finally{
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

}

class Producer implements Runnable{
    private Good good;

    public Producer(Good good) {
        this.good = good;
    }

    @Override
    public void run() {
        while(true){
            this.good.setGoods("阿玛尼唇釉400");
        }
    }

}

class Consumer implements Runnable{
    private Good good;

    public Consumer(Good good) {
        this.good = good;
    }

    @Override
    public void run() {
        while(true){
            this.good.getGood();
        }
    }
}

public class ProAndCus2 {
    public static void main(String[] args) {
        Good good = new Good(10);
        Producer producer = new Producer(good);
        Consumer consumer = new Consumer(good);
        List<Thread> list = new ArrayList<>();
        for(int i = 0;i<5;i++){
            Thread thread = new Thread(producer,"生产者"+i);
            list.add(thread);
        }
        for(int i = 0;i<10;i++){
            Thread thread = new Thread(consumer,"消费者"+i);
            list.add(thread);
        }
        for(Thread thread:list){
            thread.start();
        }
    }
}
