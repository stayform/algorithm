package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * AuThor：StAY_
 * Create:2020/5/4
 */
public class Lock_Condition_ABC {
    /**
    private static Lock lock = new ReentrantLock();
    private static Condition A = lock.newCondition();
    private static Condition B = lock.newCondition();
    private static Condition C = lock.newCondition();

    private static int count = 0;

    static class ThreadA extends Thread{
        @Override
        public void run() {
            try{
                lock.lock();
                for(int i=0;i<10;i++){
                    while(count%3!=0){
                        A.await();
                    }
                    System.out.println("A");
                    count++;
                    B.signal();//A执行完唤醒B
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        }
    }

    static class ThreadB extends Thread{
        public void run(){
            try{
                lock.lock();
                for(int i=0;i<10;i++){
                    while(count%3!=1){
                        B.await();
                    }
                    System.out.println("B");
                    count++;
                    C.signal();
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        }
    }
    static class ThreadC extends Thread{
        public void run(){
            try{
                lock.lock();
                for(int i=0;i<10;i++){
                    while(count%3!=2){
                        C.await();
                    }
                    System.out.println("C");
                    count++;
                    A.signal();
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }*/

    private static Lock lock = new ReentrantLock();
    private static Condition a = lock.newCondition();
    private static Condition b = lock.newCondition();
    private static Condition c = lock.newCondition();

    private static int count=0;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    try{
                        lock.lock();
                        while(count%3!=0){
                            a.await();
                        }
                        System.out.println(Thread.currentThread().getName()+" A");
                        count++;
                        b.signal();//线程B一直在await()阻塞着，只有把它唤醒才能让接下来的代码顺利执行
                    }catch(Exception e){
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        },"ThreadA").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    try{
                        lock.lock();
                        while(count%3!=1){
                            b.await();
                        }
                        System.out.println(Thread.currentThread().getName()+" B");
                        count++;
                        c.signal();
                    }catch(Exception e){
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        },"ThreadB").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    try{
                        lock.lock();
                        while(count%3!=2){
                            c.await();
                        }
                        System.out.println(Thread.currentThread().getName()+" C");
                        count++;
                        a.signal();
                    }catch(Exception e){
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        },"ThreadC").start();
    }

}
