package thread;

/**
 * AuThor：StAY_
 * Create:2020/5/1
 */
//实现Runnable接口
public class Demo2 {
    public static class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"thread run...");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable run = new MyRunnable();
        Thread t = new Thread(run);
        Thread t2 = new Thread(run);
        t.start();
        t2.start();
        new Thread(run).start();


    }
}
