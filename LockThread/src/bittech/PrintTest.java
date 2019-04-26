package bittech;

/**
*  1.写两个线程，一个打印1-52，另一个打印A-Z
*    打印顺序是12A34B...5152Z
*/

class Print{

    //设置标记位,此刻这个线程该不该执行
    boolean flag = true;
    private int count = 1;

    public synchronized void printNumber(){
        if(flag==false){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(2*count-1);
        System.out.print(2*count);
        //执行完毕，该打印字母线程执行
        //唤醒打印字母线程
        flag = false;
        notify();
    }

    public synchronized void printChar(){
        if(flag==true){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print((char)('A'+count-1));
        flag = true;
        //因为每次打印完字母一次完整流程就执行完毕了
        count++;
        notify();
    }

}

public class PrintTest {
    public static void main(String[] args) {
        Print print = new Print();
//        new Thread(()->{
//            for(int i=0;i<26;i++){
//                print.printNumber();
//            }
//        }).start();
//        new Thread(()->{
//            for(int i=0;i<26;i++){
//                print.printChar();
//            }
//        }).start();
    }
}
