package javaconcurrent.threadpoolexecutor.shutdownnow;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池shutdownNow 任务没有完成，就立即中断了，任务报错被中断。剩下的任务也被取消了
 */
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable1 myRunnable1 = new MyRunnable1();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 9999, 9999L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        pool.execute(myRunnable1);
        pool.execute(myRunnable1);
        pool.execute(myRunnable1);
        pool.execute(myRunnable1);
        Thread.sleep(1000);
        pool.shutdownNow();
    }
}
