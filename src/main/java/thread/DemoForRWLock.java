package thread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * AuThor：StAY_
 * Create:2020/5/1
 */
public class DemoForRWLock {
    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        Thread t = new Thread(new Runnable(){
            public void run(){
                lock.writeLock().lock();
                System.out.println("t start");
                lock.writeLock().unlock();
            }
        });
        lock.writeLock().lock();
        lock.writeLock().lock();
        t.start();
        System.out.println("t not start");
        lock.writeLock().unlock();
        lock.writeLock().unlock();//只有两次解锁后，t线程才能获取锁
    }
}
