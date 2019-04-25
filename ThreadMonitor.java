package bittech;

//证明锁的可重入性与互斥

class MyThread4 implements Runnable{

    @Override
    public void run() {
        test1();
        //test2();
    }

    public synchronized void test1(){
        if(Thread.currentThread().getName().equals("A")){
//            while(true){
//
//            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A线程进入test1");
            test2();
        }
    }

    public synchronized void test2(){
//        if(Thread.currentThread().getName().equals("B")){
//            System.out.println("B线程进入该同步方法test2...");
//        }else{
//            System.out.println(Thread.currentThread().getName()+"进入test2方法...");
//        }
        System.out.println("可重入性");
    }

}

public class ThreadMonitor {
    public static void main(String[] args) throws InterruptedException {
        MyThread4 myThread4 = new MyThread4();
        Thread thread1 = new Thread(myThread4,"A");
        Thread thread2 = new Thread(myThread4,"B");
        thread1.start();
        Thread.sleep(1000);
        thread2.start();
    }
}
