package javaconcurrent.threadpoolexecutor.coreThreadTimeout;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 配置核心线程是否有超时的效果 allowsCoreThreadTimeOut
 */
public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(4, 5, 5, TimeUnit.SECONDS
                , new SynchronousQueue<>());
        pool.allowCoreThreadTimeOut(true);
        System.out.println(pool.allowsCoreThreadTimeOut());
        for (int i = 0; i < 4; i++) {
            MyRunnable myRunnable = new MyRunnable();
            pool.execute(myRunnable);
        }
        Thread.sleep(8000);
        System.out.println(pool.getPoolSize());
    }
}
