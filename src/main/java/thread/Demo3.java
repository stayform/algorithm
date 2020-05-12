package thread;

/**
 * AuThor：StAY_
 * Create:2020/5/1
 */
//函数式编程
public class Demo3 {
    public static void main(String[] args) {
        new Thread(()->{
            for(int i=0;i<5;i++){
                System.out.println(i);
            }
        }).start();
        new Thread(()->{
            for(int i=0;i<5;i++){
                System.out.println(i);
            }
        }).start();

        new Thread(new Runnable(){
            @Override
            public void run() {

            }
        }).start();
    }
}
