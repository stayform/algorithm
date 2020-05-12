package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * AuThor：StAY_
 * Create:2020/5/4
 */
public class AtomicInteger_ABC {
    private AtomicInteger ai = new AtomicInteger(0);
    private static final int MAX_SYC_VALUE = 3*10;//ai的取值范围0~30

    private class RunnableA implements Runnable{
        @Override
        public void run() {
            while(ai.get()<=MAX_SYC_VALUE-1){
                if(ai.get()%3==0){
                    System.out.println("A");
                    ai.getAndIncrement();//对ai进行+1操作
                }
            }
        }
    }
    private class RunnableB implements Runnable{
        @Override
        public void run() {
            while(ai.get()<=MAX_SYC_VALUE-1){
                if(ai.get()%3==1){
                    System.out.println("B");
                    ai.getAndIncrement();//对ai进行+1操作
                }
            }
        }
    }
    private class RunnableC implements Runnable{
        @Override
        public void run() {
            while(ai.get()<=MAX_SYC_VALUE-1){
                if(ai.get()%3==2){
                    System.out.println("C");
                    ai.getAndIncrement();//对ai进行+1操作
                }
            }
        }
    }

    public static void main(String[] args) {
        /**AtomicInteger_ABC atomicInteger_abc = new AtomicInteger_ABC();
        ExecutorService service = Executors.newFixedThreadPool(3);

        service.execute(atomicInteger_abc.new RunnableA());
        service.execute(atomicInteger_abc.new RunnableB());
        service.execute(atomicInteger_abc.new RunnableC());*/
        AtomicInteger_ABC atomicInteger_abc = new AtomicInteger_ABC();
        new Thread( atomicInteger_abc.new RunnableA()).start();
        new Thread( atomicInteger_abc.new RunnableB()).start();
        new Thread( atomicInteger_abc.new RunnableC()).start();
    }
}
