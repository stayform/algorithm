package thread;

import java.io.ObjectInputStream;

/**
 * AuThor：StAY_
 * Create:2020/3/23
 */
public class Locked {
   public static Object obj = new Object();
   public static Object obj2 = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized(obj){
                try {
                    System.out.println(Thread.currentThread().getName()+"get obj...");
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (obj2){
                    System.out.println("get obj2");
                }
            }
        }).start();
        new Thread(()->{
            synchronized(obj2){
                try {
                    System.out.println(Thread.currentThread().getName()+"get obj2...");
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (obj){
                    System.out.println("get obj...");
                }
            }
        }).start();
    }
}
