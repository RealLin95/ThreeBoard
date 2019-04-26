package bittech;

/**
*  2.编写一个程序，启动三个线程，三个线程的名称分别是A,B,C;
 *   每个线程将自己的名称在屏幕上打印5遍，打印顺序是ABCABC...
*
*/

class Prints{
    //设置标记位，用数字表示三个线程
    private int flag = 1;
    //表示打印的次数
    private int count = 1;

    public int getCount() {
        return count;
    }

    public synchronized void printA(){
        while(flag!=1){//循环打印5次，若用if则顺序执行，不能达到效果
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());
        flag=2;
        count++;
        notifyAll();
    }

    public synchronized void printB(){
        while(flag!=2){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());
        flag=3;
        count++;
        notifyAll();
    }

    public synchronized void printC(){
        while(flag!=3){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());
        flag = 1;
        count++;
        notifyAll();
    }

}

class MyThread implements Runnable{
    Prints prints;

    public MyThread(Prints prints) {
        this.prints = prints;
    }

    @Override
    public void run() {
        while(prints.getCount()<=13){//13是第五次A出现的count的数字
            if(Thread.currentThread().getName().equals("A")){
                this.prints.printA();
            }else if(Thread.currentThread().getName().equals("B")){
                this.prints.printB();
            }else if(Thread.currentThread().getName().equals("C")){
                this.prints.printC();
            }
        }
    }
}

public class PrintString {
    public static void main(String[] args) {
        Prints prints = new Prints();
//        new Thread(()->{
//            for(int i=0;i<5;i++){
//                if(Thread.currentThread().getName().equals("A")){
//                    prints.printA();
//                }
//            }
//        },"A").start();
//        new Thread(()->{
//            for(int i=0;i<5;i++){
//                if(Thread.currentThread().getName().equals("B")){
//                    prints.printB();
//                }
//            }
//        },"B").start();
//        new Thread(()->{
//            for(int i=0;i<5;i++){
//                if(Thread.currentThread().getName().equals("C")){
//                    prints.printC();
//                }
//            }
//        },"C").start();
        MyThread myThread = new MyThread(prints);
        new Thread(myThread,"A").start();
        new Thread(myThread,"B").start();
        new Thread(myThread,"C").start();
    }
}
