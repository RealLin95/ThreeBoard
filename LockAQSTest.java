package bittech;

import javax.xml.soap.Node;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockAQSTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        for(int i = 0;i<5;i++){
            Thread thread = new Thread(()->{
                lock.lock();
                try{
                    try {
                        condition.await();
                        condition.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }finally{
                lock.unlock();
                }
            });
            thread.start();
        }
    }
}
