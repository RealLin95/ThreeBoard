package bittech;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Goods{
   private int maxGoods;
   private int count;
   private String goodsName;
   //使用Lock锁
   Lock lock = new ReentrantLock();
   // 新建一个生产者等待队列和消费者等待队列
   Condition producersCondition = lock.newCondition();
   Condition customersCondition = lock.newCondition();

    public Goods(int maxGoods) {
        this.maxGoods = maxGoods;
    }

    public void setGoods(String goodsName){
        lock.lock();
        try{
            while(count==maxGoods){
                System.out.println("商品已满，等待消费");
                try {
                    producersCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 当前商品在合理范围内，正常生产成功，唤醒消费
            this.goodsName = goodsName;
            count++;
            System.out.println(Thread.currentThread().getName()+"生产"+toString());
            customersCondition.signalAll();
        }finally{
            lock.unlock();
        }
    }

    public void getGoods(){
        lock.lock();
        try{
            while(count==0){
                System.out.println("商品已空，等待生产");
                try {
                    customersCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count--;
            System.out.println(Thread.currentThread().getName()+"消费"+toString());
            producersCondition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "Goods{" +
                "count=" + count +
                ", goodsName='" + goodsName + '\'' +
                '}';
    }

}

class Producers implements Runnable{
    private Goods goods;

    public Producers(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true) {
            this.goods.setGoods("Burberry牛血色唇釉");
        }
    }

}

class Customers implements Runnable{
    private Goods goods;

    public Customers(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while(true){
            this.goods.getGoods();
        }
    }

}

public class Model {
    public static void main(String[] args) {
        Goods goods = new Goods(30);
        Producers producers = new Producers(goods);
        Customers customers = new Customers(goods);
        List<Thread> list = new ArrayList<>();
        for(int i=1;i<4;i++){
            Thread thread = new Thread(producers,"生产者"+i);
            list.add(thread);
        }
        for(int i = 1;i<6;i++){
            Thread thread = new Thread(customers,"消费者"+i);
            list.add(thread);
        }
        for(Thread thread:list){
            thread.start();
        }
    }
}
