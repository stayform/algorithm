package thread;

import java.io.ObjectInputStream;

/**
 * AuThor：StAY_
 * Create:2020/5/3
 */
public class Sychronized_ABC {
    static class MyThread implements Runnable{
        private String name;
        private Object prev;
        private Object self;
        public MyThread(String name,Object prev,Object self){
            this.name = name;
            this.prev = prev;
            this.self = self;
        }
        @Override
        public void run() {
            int count=10;
            while(count>0) {
                synchronized (prev) {//先获取当前线程之前执行的那个线程的锁，如果获取到了证明之前的线程执行完毕
                   synchronized (self){
                       System.out.println(Thread.currentThread().getName()+" "+name);
                       count--;
                       self.notifyAll();//当前线程执行完毕立刻唤醒其他线程
                   }
                   try{
                       if(count==0)//如果当前是最后一次打印，释放对象锁
                           prev.notifyAll();
                       else{
                           prev.wait();//立即释放prev锁
                   }
                    }catch(InterruptedException e){
                       e.printStackTrace();
                   }

                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        MyThread t1= new MyThread("A",c,a);
        MyThread t2= new MyThread("B",a,b);
        MyThread t3= new MyThread("C",b,c);

        new Thread(t1).start();
        Thread.sleep(10);
        new Thread(t2).start();
        Thread.sleep(10);
        new Thread(t3).start();

    }
}
