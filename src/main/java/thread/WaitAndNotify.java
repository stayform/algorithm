package thread;

/**
 * AuThor：StAY_
 * Create:2020/4/5
 */
public class WaitAndNotify {
    /**打印奇偶数
    private static Object lock=new Object();
    private static  int i=0;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(i<20){
                    try {
                        synchronized (lock) {
                            if(i%2==0){
                                System.out.println(Thread.currentThread().getName()+" 输出偶数 "+i);
                                i++;
                            }else{
                                lock.notify();
                                lock.wait();
                            }
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        },"Thread0").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(i<20){
                    try {
                        synchronized (lock) {
                            if(i%2==1){
                                System.out.println(Thread.currentThread().getName()+" 输出奇数 "+i);
                                i++;
                            }else{
                                lock.notify();
                                lock.wait();
                            }
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        },"Thread1").start();

    }*/

    private static Object obj = new Object();
    private static int i=0;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(i<30){
                    try{
                        synchronized (obj){
                            if(i%3==0){
                                System.out.println(Thread.currentThread().getName()+"  A");
                                i++;
                            }else{
                                obj.notifyAll();//唤醒所有在等待状态的线程，notify/notifyAll() 的执行只是唤醒沉睡的线程，而不会立即释放锁要等到wait方法这个线程才会释放对象锁
                                obj.wait();//释放对象锁
                            }
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        },"ThreadA").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(i<30){
                    try{
                        synchronized (obj){
                            if(i%3==1){
                                System.out.println(Thread.currentThread().getName()+"  B");
                                i++;
                            }else{
                                obj.notifyAll();
                                obj.wait();
                            }
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        },"ThreadB").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(i<30){
                    try{
                        synchronized (obj){
                            if(i%3==2){
                                System.out.println(Thread.currentThread().getName()+"  C");
                                i++;
                            }else{
                                obj.notifyAll();
                                obj.wait();
                            }
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        },"ThreadC").start();
    }


}
/**
 *
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
