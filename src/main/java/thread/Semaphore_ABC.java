package thread;

import com.sun.scenario.effect.impl.prism.PrImage;

import java.util.concurrent.Semaphore;

/**
 * AuThor：StAY_
 * Create:2020/5/4
 */
public class Semaphore_ABC {
    private static Semaphore A = new Semaphore(1);
    private static Semaphore B = new Semaphore(0);
    private static Semaphore C = new Semaphore(0);
/**
    static class ThreadA extends Thread{
        @Override
        public void run() {
            try{
                for(int i=0;i<10;i++){
                    A.acquire();//A获取信号执行
                    System.out.println("A");
                    B.release();//B释放一个信号，B信号量+1（初始为0）
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    static class ThreadB extends Thread{
        @Override
        public void run() {
            try{
                for(int i=0;i<10;i++){
                    B.acquire();//B获取信号执行
                    System.out.println("B");
                    C.release();//C释放一个信号，C信号量+1（初始为0）
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    static class ThreadC extends Thread{
        @Override
        public void run() {
            try{
                for(int i=0;i<10;i++){
                    C.acquire();//C获取信号执行
                    System.out.println("C");
                    A.release();//A释放一个信号，A信号量+1（初始为0）
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }*/

    public static void main(String[] args) {
        new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    try{
                        A.acquire();
                        System.out.println("A");
                        B.release();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    try{
                        B.acquire();
                        System.out.println("B");
                        C.release();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    try{
                        C.acquire();
                        System.out.println("C");
                        A.release();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
