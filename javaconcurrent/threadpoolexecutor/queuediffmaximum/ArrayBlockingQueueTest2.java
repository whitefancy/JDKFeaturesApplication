package javaconcurrent.threadpoolexecutor.queuediffmaximum;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 任务书多于队列的容量，报错，拒绝放入。
 */
public class ArrayBlockingQueueTest2 {
    public static void main(String[] args) {
        ArrayBlockingQueue array = new ArrayBlockingQueue<Runnable>(2);
        System.out.println(array.size());
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3,
                5, TimeUnit.SECONDS, array);
        pool.execute(new MyRunnable());
        pool.execute(new MyRunnable());
        pool.execute(new MyRunnable());
        pool.execute(new MyRunnable());
        pool.execute(new MyRunnable());
        pool.execute(new MyRunnable());
        System.out.println(pool.getPoolSize() + " " + array.size());
    }
}
