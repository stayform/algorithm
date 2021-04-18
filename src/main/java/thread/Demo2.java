package thread;

/**
 * AuThor：StAY_
 * Create:2020/5/1
 */
//实现Runnable接口
public class Demo2 implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<100;i++) {
            System.out.println(Thread.currentThread().getName() + "  " + i);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Runnable run = new Demo2();
        new Thread(run).start();
        new Thread(run).start();


    }
}
