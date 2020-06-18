package javaconcurrent.threadpoolexecutor.coreThreadTimeout;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 配置核心线程是否有超时的效果 allowsCoreThreadTimeOut
 * 核心线程是初始化线程池时的线程数，如果有超时效果，则核心线程池中的线程不保活
 */
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(4, 5, 5, TimeUnit.SECONDS
                , new SynchronousQueue<>());
        System.out.println(pool.allowsCoreThreadTimeOut());
        for (int i = 0; i < 4; i++) {
            MyRunnable myRunnable = new MyRunnable();
            pool.execute(myRunnable);
        }
        Thread.sleep(8000);
        System.out.println(pool.getPoolSize());
    }
}
