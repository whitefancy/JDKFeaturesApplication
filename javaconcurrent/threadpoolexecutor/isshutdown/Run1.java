package javaconcurrent.threadpoolexecutor.isshutdown;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 只要调用了shutdown，isshutdown的值就是true
 * <p>
 * A:false
 * 打印了！ begin pool-1-thread-11569401725970
 * B:true
 * 打印了！ end pool-1-thread-11569401726972
 */
public class Run1 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(" 打印了！ begin " + Thread.currentThread().getName() + System.currentTimeMillis());
                    Thread.sleep(1000);
                    System.out.println(" 打印了！ end " + Thread.currentThread().getName() + System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2,
                Integer.MAX_VALUE, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>());
        executor.execute(runnable);
        System.out.println("A:" + executor.isShutdown());
        executor.shutdown();
        System.out.println("B:" + executor.isShutdown());
    }
}
