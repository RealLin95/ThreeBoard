package bittech;

/*class MyThreadA implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" "
                +Thread.currentThread().getPriority());
        new Thread(new MyThreadB(),"子线程的子线程").start();
    }
}

class MyThreadB implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" "
                +Thread.currentThread().getPriority());
    }
}

public class Thread1{
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+" "
                +Thread.currentThread().getPriority());
        new Thread(new MyThreadA(),"子线程").start();
    }
}
*/

class MyThread implements Runnable{

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
                boolean flag = Thread.currentThread().isDaemon();
                if(flag){
                    System.out.println(Thread.currentThread().getName()+"是守护线程");
                }else{
                    System.out.println(Thread.currentThread().getName()+"不是守护线程");
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+"退出...");
                return;
            }
        }
    }
}
public class Thread1{
    public static void main(String[] args) throws InterruptedException{
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread,"子线程A");
        Thread thread2 = new Thread(myThread,"子线程B");
        thread1.setDaemon(true);
        thread1.start();
        thread2.start();
        Thread.sleep(3000);
        thread2.interrupt();
    }
}