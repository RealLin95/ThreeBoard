package bittech;

class MyThread implements Runnable{
    private boolean flag;
    private Object object;

    public MyThread(boolean flag,Object object){
        this.flag = flag;
        this.object = object;
    }

    public void waitMethod(){
        synchronized (object){
            System.out.println(Thread.currentThread().getName()+"wait begin...");
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"wait end...");
        }
    }

    public void notifyMethod(){
        synchronized (object){
            System.out.println(Thread.currentThread().getName()+"notify begin...");
            object.notifyAll();
            System.out.println(Thread.currentThread().getName()+"notify end...");
        }
    }

    @Override
    public void run() {
        if(flag){
            waitMethod();
        }else{
            notifyMethod();
        }
    }
}
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        MyThread myThread2 = new MyThread(false,object);
        for(int i = 0;i<3;i++){
            MyThread myThread1 = new MyThread(true,object);
            Thread thread1 = new Thread(myThread1,"WaitThread"+i);
            thread1.start();
        }
        Thread thread2 = new Thread(myThread2,"NotifyThread");
        Thread.sleep(1000);
        thread2.start();
    }
}
