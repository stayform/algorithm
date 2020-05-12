package thread;

import java.io.ObjectInputStream;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * AuThor：StAY_
 * Create:2020/5/1
 */
public class DemoForLock {
   private static Lock lock = new ReentrantLock();
   //private static Object obj = new Object();
    public static class MyReentrantLock extends Thread{
        public void run() {
            //synchronized (obj){
            lock.lock();
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + i);
            }
            lock.unlock();
           //}
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new MyReentrantLock();
        Thread t2 = new MyReentrantLock();
        Thread t3 = new MyReentrantLock();
        t1.start();
        t2.start();
        t3.start();
    }
}
