package bittech;

class Sync{
     public synchronized void fun() {
         System.out.println(Thread.currentThread().getName()+"fun方法开始...");
         try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         System.out.println(Thread.currentThread().getName()+"fun方法结束...");
     }
}

class MyThread3 implements Runnable{

    //保证锁的是同一个对象
    private Sync sync;

    public MyThread3(Sync sync){
        this.sync = sync;
    }

    @Override
    public void run() {
        this.sync.fun();
        //三个对象各自锁各自的，互相不影响
        /*Sync sync = new Sync();
        sync.fun();*/
    }
}

public class Thread3 {
    public static void main(String[] args) {
        Sync sync = new Sync();
        MyThread3 myThread3 = new MyThread3(sync);
        Thread thread1 = new Thread(myThread3,"线程A");
        Thread thread2 = new Thread(myThread3,"线程B");
        Thread thread3 = new Thread(myThread3,"线程C");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
