package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * AuThor：StAY_
 * Create:2020/5/3
 */
public class Lock_State_ABC {
    private static Lock lock = new ReentrantLock();
    private static int state = 0;
    static class MyThreadA extends Thread{
        @Override
        public void run() {
             for(int i=0;i<10;){
                 try{
                     lock.lock();
                     while(state%3==0){
                         System.out.println("A");
                         state++;
                         i++;
                     }
                 }finally {
                     lock.unlock();
                 }
             }
        }
    }
    static class MyThreadB extends Thread{
        @Override
        public void run() {
            for(int i=0;i<10;){
                try{
                    lock.lock();
                    while(state%3==1){
                        System.out.println("B");
                        state++;
                        i++;
                    }
                }finally {
                    lock.unlock();
                }
            }
        }
    }
    static class MyThreadC extends Thread{
        @Override
        public void run() {
            for(int i=0;i<10;){
                try{
                    lock.lock();
                    while(state%3==2){
                        System.out.println("C");
                        state++;
                        i++;
                    }
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        new MyThreadA().start();
        new MyThreadB().start();
        new MyThreadC().start();
    }
}
