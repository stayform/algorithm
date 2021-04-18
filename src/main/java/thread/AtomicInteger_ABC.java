package thread;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * AuThor：StAY_
 * Create:2020/5/4
 */
public class AtomicInteger_ABC{

    //这种会出现打印出第30（也就是A）的情况，因为某次A线程已经进入了循环之后才C线程才执行的++操作，所以A线程得以继续执行if判断从而打印出A
    //所以如果要求打印出固定数量的ABC不适合用此方法，如果只让交替打印没有要求打印多少套的话可以用它
    private static  AtomicInteger atomicInteger = new AtomicInteger(0);
    private static final int MAX_SYC_VALUE = 3*10;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(atomicInteger.get()<=MAX_SYC_VALUE-1){
                    if(atomicInteger.get()%3==0){
                        System.out.println(Thread.currentThread().getName()+" A");
                        atomicInteger.getAndIncrement();
                    }
                }
            }
        },"threadA").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(atomicInteger.get()<=MAX_SYC_VALUE-1){
                    if(atomicInteger.get()%3==1){
                        System.out.println(Thread.currentThread().getName()+" B");
                        atomicInteger.getAndIncrement();
                    }
                }
            }
        },"threadB").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(atomicInteger.get()<=MAX_SYC_VALUE-1){
                    if(atomicInteger.get()%3==2){
                        System.out.println(Thread.currentThread().getName()+" C");
                        atomicInteger.getAndIncrement();
                    }
                }
            }
        },"threadC").start();
    }

}
