package thread; /**
 * AuThor：StAY_
 * Create:2020/4/2
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//单线程线程池
public class SingleTest {
        public static void main(String[] args) {
            ExecutorService single = Executors.newSingleThreadExecutor();//创建一个单线程的线程池
            for(int i=0;i<5;i++){//共有五个任务
                final int index=i;
                single.execute(new Runnable(){
                    public void run(){
                        try{
                            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                            System.out.println("运行时间"+sdf.format(new Date())+" "+index);
                            Thread.sleep(1000);
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                });
            }
            single.shutdown();
        }
}

