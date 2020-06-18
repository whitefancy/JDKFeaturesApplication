package javaconcurrent.threadpoolexecutor.queuediffmaximum;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueTest2 {
    public static void main(String[] args) {
        SynchronousQueue queue = new SynchronousQueue<Runnable>();
        System.out.println(queue.size());
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3,
                5, TimeUnit.SECONDS, queue);
        pool.execute(new MyRunnable());
        pool.execute(new MyRunnable());
        pool.execute(new MyRunnable());
        pool.execute(new MyRunnable());
        pool.execute(new MyRunnable());
        System.out.println(pool.getPoolSize() + " " + queue.size());
    }
}
