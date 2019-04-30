package bittech;

class Pen{

}

class Book{

}

public class DeadLock {
    private static Pen pen = new Pen();
    private static Book book = new Book();
    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
           synchronized (pen){
               System.out.println("借书");
//               synchronized (book){
//                   System.out.println("先借我笔");
//               }
           }
        });
        Thread thread2 = new Thread(()->{
           synchronized (book){
               System.out.println("借笔");
               synchronized (pen){
                   System.out.println("先借我书");
               }
           }
        });
        thread1.start();
        thread2.start();
    }
}
