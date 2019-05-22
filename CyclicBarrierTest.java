package com.bittech.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

class CyclicTask implements Runnable{
    private CyclicBarrier cyclicBarrier;

    public CyclicTask(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"正在写入数据...");
        try {
            TimeUnit.SECONDS.sleep(2);
            //所有调用await()的子线程都会阻塞，直到全部写入完毕
            cyclicBarrier.await();
            System.out.println("所有线程都已将数据写入完毕，同时恢复执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

public class CyclicBarrierTest {
    public static void main(String[] args) {
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("随机挑选的子线程为："+Thread.currentThread().getName());
            }
        });
        for(int i=0;i<3;i++){
            new Thread(new CyclicTask(cyclicBarrier),"写入线程"+i).start();
        }
    }
}
