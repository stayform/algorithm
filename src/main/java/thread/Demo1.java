package thread;

/**
 * AuThor：StAY_
 * Create:2020/5/1
 */
//继承Thread类
public class Demo1 extends Thread{

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }


    public static void main(String[] args) {
        Thread t = new Demo1();
        Thread t2 = new Demo1();
        t.start();
        t2.start();
    }
}
