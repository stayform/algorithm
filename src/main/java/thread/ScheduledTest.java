package thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * AuThor：StAY_
 * Create:2020/4/2
 */
public class ScheduledTest {
    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        ScheduledExecutorService schedule = Executors.newScheduledThreadPool(6);
        System.out.println("submit"+sdf.format(new Date()));
        schedule.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("runtime"+sdf.format(new Date()));
            }
        },4,2,TimeUnit.SECONDS);//initialDelay表示提交与第一次执行的延迟，period表示每次执行的延迟
        Thread.sleep(10000);
        schedule.shutdown();
    }
}
