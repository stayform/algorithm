package thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * AuThor：StAY_
 * Create:2020/4/2
 */
//固定大小的线程池
//同一时间运行的线程数由参数决定 同一时间运行的顺序随意
public class FixedTest {
    public static void main(String[] args) {
        ExecutorService fixed = Executors.newFixedThreadPool(5);
        for(int i=0;i<20;i++){
             final int index = i;
            fixed.execute(new Runnable(){
                public void run(){
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                        System.out.println("运行时间" + sdf.format(new Date()) + " " + index);
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });
        }
        fixed.shutdown();
    }
}
