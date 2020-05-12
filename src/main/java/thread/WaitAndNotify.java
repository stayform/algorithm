package thread;

/**
 * AuThor：StAY_
 * Create:2020/4/5
 */
public class WaitAndNotify {
    private static Object lock=new Object();
    private static  int i=0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(i<10){
                        synchronized (lock) {
                            if (i % 2 == 0) {
                                System.out.println("由线程"+Thread.currentThread().getName()+"打印 偶数"+ i);
                                i++;
                            } else {
                                lock.notify();
                                lock.wait();
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(1000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(i<10){
                        synchronized (lock) {
                            if (i % 2 == 1) {
                                System.out.println("由线程"+Thread.currentThread().getName()+"打印 奇数" + i);
                                i++;

                            } else {
                                lock.notify();
                                lock.wait();
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();



    }
}
/**
 * 信号量实现法
 * public class Signal {
 *     private static volatile int signal = 0;
 *
 *     static class ThreadA implements Runnable {
 *         @Override
 *         public void run() {
 *             while (signal < 5) {
 *                 if (signal % 2 == 0) {
 *                     System.out.println("threadA: " + signal);
 *                     synchronized (this) {
 *                         signal++;
 *                     }
 *                 }
 *             }
 *         }
 *     }
 *
 *     static class ThreadB implements Runnable {
 *         @Override
 *         public void run() {
 *             while (signal < 5) {
 *                 if (signal % 2 == 1) {
 *                     System.out.println("threadB: " + signal);
 *                     synchronized (this) {
 *                         signal = signal + 1;
 *                     }
 *                 }
 *             }
 *         }
 *     }
 *
 *     public static void main(String[] args) throws InterruptedException {
 *         new Thread(new ThreadA()).start();
 *         Thread.sleep(1000);
 *         new Thread(new ThreadB()).start();
 *     }
 * }
 */
