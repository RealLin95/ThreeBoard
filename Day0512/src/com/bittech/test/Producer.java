package com.bittech.test;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable{
    private final Queue<Goods> goodsQueue;
    private final Integer maxGoods;
    private final long speed;
    //商品序号
    private final AtomicInteger goodsId = new AtomicInteger(0);

    public Producer(Queue<Goods> goodsQueue, Integer maxGoods, long speed) {
        this.goodsQueue = goodsQueue;
        this.maxGoods = maxGoods;
        this.speed = speed;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this.goodsQueue){
                if(this.goodsQueue.size()>=this.maxGoods){
                    try {
                        System.out.println(Thread.currentThread().getName()
                                +"当前商品队列已满，等待消费...");
                        this.goodsQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    Goods goods = new Goods("商品-"
                            +goodsId.getAndDecrement(),100.00);
                    this.goodsQueue.add(goods);
                    System.out.println(Thread.currentThread().getName()+"   生产商品"+goods);
                }
            }
        }
    }

}
