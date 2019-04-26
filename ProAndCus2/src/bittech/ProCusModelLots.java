package bittech;

//多生产--多消费--多个商品

import java.util.ArrayList;
import java.util.List;

class Good{

    private String goodName;
    private int count;

    public synchronized void setGood(String goodName){
        while(this.count>5){
            try {
                System.out.println("商品没有卖完，等待消费...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.goodName = goodName;
        this.count++;
        System.out.println(Thread.currentThread().getName()+"生产商品"+toString());
        notifyAll();
    }

    public synchronized void getGood(){
        while(this.count==0){
            try {
                System.out.println("商品卖完了，等待生产...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.count--;
        System.out.println(Thread.currentThread().getName()+"消费商品"+toString());
        notifyAll();
    }

    @Override
    public String toString() {
        return "Good{" +
                "goodName='" + goodName + '\'' +
                ", count=" + count +
                '}';
    }

}

class Producers implements Runnable{

    private Good good;

    public Producers(Good good) {
        this.good = good;
    }

    @Override
    public void run() {
        while(true){
            this.good.setGood("Mac圣诞礼盒");
        }
    }

}

class Consumers implements Runnable{

    private Good good;

    public Consumers(Good good) {
        this.good = good;
    }

    @Override
    public void run() {
        while(true){
            this.good.getGood();
        }
    }

}

public class ProCusModelLots{
    public static void main(String[] args) {
        Good good = new Good();
        Producers producers = new Producers(good);
        Consumers consumers = new Consumers(good);
        List<Thread> list = new ArrayList<>();
        for(int i = 0;i<3;i++){
            Thread thread = new Thread(producers,"生产者"+i);
            list.add(thread);
        }
        for(int i=0;i<6;i++){
            Thread thread = new Thread(consumers,"消费者"+i);
            list.add(thread);
        }
        for(Thread thread:list){
            thread.start();
        }
    }
}