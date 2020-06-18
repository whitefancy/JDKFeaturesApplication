package javaconcurrent.threadpoolexecutor.queuediffmaximum;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class LinkedBlockingDequeTest3 {
    public static void main(String[] args) {
        //无参构造，队列的最大长度是Integer.MAX_VALUE
        LinkedBlockingDeque linked = new LinkedBlockingDeque<Runnable>();
        System.out.println(linked.size());
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS, linked);
        pool.execute(new MyRunnable());
        pool.execute(new MyRunnable());
        pool.execute(new MyRunnable());
        pool.execute(new MyRunnable());
        pool.execute(new MyRunnable());
        pool.execute(new MyRunnable());
        System.out.println(pool.getPoolSize() + " " + linked.size());
    }
}
