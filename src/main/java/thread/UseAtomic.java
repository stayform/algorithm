package thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * AuThor：StAY_
 * Create:2020/5/3
 */
public class UseAtomic {
    public static void main(String[] args) {
        AtomicInteger atomicInteger=new AtomicInteger();
        for(int i=0;i<10;i++){
            Thread t=new Thread(new AtomicTest(atomicInteger));
            t.start();
            try {
                t.join(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println(atomicInteger.get());
    }
}
class AtomicTest implements Runnable{
    AtomicInteger atomicInteger;

    public AtomicTest(AtomicInteger atomicInteger){
        this.atomicInteger=atomicInteger;
    }
    @Override
    public void run() {
        atomicInteger.addAndGet(1);//给变量atomicInteger加上1
        atomicInteger.addAndGet(2);//在变量的基础上加上2
        atomicInteger.addAndGet(3);
        atomicInteger.addAndGet(3);
    }
}
