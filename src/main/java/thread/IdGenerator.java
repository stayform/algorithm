package thread;

import com.linkedlist.MyDoublyListNode;

import java.util.concurrent.atomic.AtomicLong;

/**
 * AuThor：StAY_
 * Create:2020/5/3
 */
public class IdGenerator {
    public static class MyThread extends Thread{
        public IdGenerator id;
        public MyThread(IdGenerator id){
            this.id=id;
        }
        @Override
        public void run() {

            System.out.println(id.getNextId());
            System.out.println(id.getNextId());
        }
    }
    AtomicLong var = new AtomicLong(0);

    public long getNextId() {
        return var.incrementAndGet();
    }

    public static void main(String[] args) {
        IdGenerator id = new IdGenerator();
        for(int i=0;i<10;i++){
            Thread t = new MyThread(id);
            t.start();
        }
    }
}


