package javaconcurrent.threadpoolexecutor.rejectPolicy;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的拒绝策略
 * caller runs策略 当任务添加被拒绝时，会调用线程池的Thread对象来处理被拒绝的任务。
 * 对当前test，main线程被使用并阻塞，严重影响程序效率。
 */
public class CallerRunsPolicyTest {
    public static void main(String[] args) {
        Runnable runnable = new MyThreadA();
        LinkedBlockingDeque queue = new LinkedBlockingDeque(2);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2,
                5, TimeUnit.SECONDS, queue,
                new ThreadPoolExecutor.CallerRunsPolicy());
        System.out.println("A begin " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        System.out.println("A end " + Thread.currentThread().getName() + " " + System.currentTimeMillis());

    }
}
