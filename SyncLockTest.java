package bittech;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//使用ReentrantLock进行同步处理

class MyThread5 implements Runnable{
    private int ticket = 500;
    private Lock ticketLock = new ReentrantLock();

    @Override
    public void run() {
        for(int i = 0;i<500;i++){
            ticketLock.lock();
            try{
                if(this.ticket>0){
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"还有"+this.ticket--+"张票");
                }
            }finally {
                ticketLock.unlock();
            }
        }
    }
}

public class SyncLockTest {
    public static void main(String[] args) {
        MyThread5 myThread5 = new MyThread5();
        Thread thread1 = new Thread(myThread5,"黄牛A");
        Thread thread2 = new Thread(myThread5,"黄牛B");
        Thread thread3 = new Thread(myThread5,"黄牛C");
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread3.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
