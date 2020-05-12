package thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * AuThor：StAY_
 * Create:2020/4/2
 */
//按照任务的数量创建线程的多少
//任务执行顺序不定
public class CachedTest {
    public static void main(String[] args) {
        ExecutorService cache = Executors.newCachedThreadPool();
        for(int i=0;i<10;i++){
            final int index = i;
            cache.execute(new Runnable(){
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
        cache.shutdown();
    }
}
