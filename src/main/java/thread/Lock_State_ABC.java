package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * AuThor：StAY_
 * Create:2020/5/3
 */
public class Lock_State_ABC {
    /**
        private static Lock lock = new ReentrantLock();
        private static int state = 1;
        static class Task1 implements Runnable{
            public void run() {
                for (int i = 0; i < 10; ) {
                    try {
                        lock.lock();
                        while (state % 3 == 1) {
                            System.out.println("A");
                            state++;
                            i++;//i++不能放在for循环里，只有确认这个线程完成了一次任务之后再i++
                        }
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }
        static class Task2 implements Runnable{
            public void run() {
                for (int i = 0; i < 10; ) {
                    try {
                        lock.lock();
                        while (state % 3 == 2) {
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
        static class Task3 implements Runnable{
            public void run() {
                for (int i = 0; i < 10; ) {
                    try {
                        lock.lock();
                        while (state % 3 == 0) {
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
        new Thread(new Task1()).start();
        new Thread(new Task2()).start();
        new Thread(new Task3()).start();
    }
     */
    private static Lock lock = new ReentrantLock();
    private static int state = 1;
    static class Jishu implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<10;){
                try{
                    lock.lock();
                    while(state%2==1){
                        System.out.println(state++);
                        i++;
                    }
                }finally {
                    lock.unlock();
                }
            }
        }
    }
    static class Oushu implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<10;){
                try{
                    lock.lock();
                    while(state%2==0){
                        System.out.println(state++);
                        i++;
                    }
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Jishu()).start();
        new Thread(new Oushu()).start();
    }
}
