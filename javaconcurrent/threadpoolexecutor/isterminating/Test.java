package javaconcurrent.threadpoolexecutor.isterminating;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * isTerminating门是否正在关闭
 * isTerminated门是否已经关闭
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable myRunnable = new MyRunnable();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 9999,
                9999, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        pool.execute(myRunnable);
        pool.execute(myRunnable);
        pool.execute(myRunnable);
        pool.execute(myRunnable);
        System.out.println(pool.isTerminating() + " " + pool.isTerminated());
        pool.shutdown();
        Thread.sleep(1000);
        System.out.println(pool.isTerminating() + " " + pool.isTerminated());
        Thread.sleep(1000);
        System.out.println(pool.isTerminating() + " " + pool.isTerminated());
        Thread.sleep(1000);
        System.out.println(pool.isTerminating() + " " + pool.isTerminated());
        Thread.sleep(1000);
        System.out.println(pool.isTerminating() + " " + pool.isTerminated());
    }
}
