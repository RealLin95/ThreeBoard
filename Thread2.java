package bittech;

class MyThread1 implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            this.sale();
            //为当前程序上锁，同一时刻只允许一个线程进入代码块处理问题
            /*synchronized (this){
                if(this.ticket>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"还剩下"+this.ticket--+"票");
                }
            }*/
        }
    }

    //表示此时只有一个线程能够进入此方法
    //隐式锁对象：this
    public synchronized void sale() {
        if (this.ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "还剩下" + this.ticket-- + "票");
        }
    }
}

public class Thread2 {
    public static void main(String[] args) {
     MyThread1 myThread1 = new MyThread1();
     Thread thread1 = new Thread(myThread1,"黄牛A");
     Thread thread2 = new Thread(myThread1,"黄牛B");
     Thread thread3 = new Thread(myThread1,"黄牛C");
     thread1.start();
     thread2.start();
     thread3.start();
    }
}
