package javaconcurrent.threadpoolexecutor.shutdown;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池shutdown后不能再提交新的任务了
 */
public class Test4 {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable1 myRunnable1 = new MyRunnable1();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 9999, 9999L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        pool.execute(myRunnable1);
        pool.execute(myRunnable1);
        pool.execute(myRunnable1);
        pool.execute(myRunnable1);
        Thread.sleep(1000);
        pool.shutdown();//void
        pool.execute(myRunnable1);
        System.out.println("main end!");
    }
}
