package com.bittech.test;

import java.util.Queue;

public class Consumer implements Runnable{
    //共享商品队列
    private final Queue<Goods> goodsQueue;
    private final long speed;

    public Consumer(Queue<Goods> goodsQueue, long speed) {
        this.goodsQueue = goodsQueue;
        this.speed = speed;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(this.speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this.goodsQueue){
                if(this.goodsQueue.isEmpty()){
                    System.out.println("当前商品队列已空，通知生产...");
                    this.goodsQueue.notifyAll();
                }else{
                    Goods goods = this.goodsQueue.poll();
                    if(goods != null){
                        System.out.println(Thread.currentThread().getName()
                        +"消费商品");
                    }
                }
            }
        }
    }
}
