package com.bittech.test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class SemaphoreTask implements Runnable{
    private Semaphore semaphore;
    private int num;

    public SemaphoreTask(Semaphore semaphore, int num) {
        this.semaphore = semaphore;
        this.num = num;
    }

    public SemaphoreTask(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        //尝试去申请设备，默认申请一个信号量（一台设备）
        try {
            semaphore.acquire(2);
            System.out.println("工人"+this.num+"占用一台设备生产");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("工人"+this.num+"释放一台设备");
            semaphore.release(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class SemaphoreTest{
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(8);
        for(int i =0;i<8;i++){
            new Thread(new SemaphoreTask(semaphore,(i+1))).start();
        }
    }
}
