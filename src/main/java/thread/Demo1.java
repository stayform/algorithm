package thread;

/**
 * AuThor：StAY_
 * Create:2020/5/1
 */
//继承Thread类
public class Demo1 {
    public static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("线程启动");
        }
    }

    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();
    }
}
