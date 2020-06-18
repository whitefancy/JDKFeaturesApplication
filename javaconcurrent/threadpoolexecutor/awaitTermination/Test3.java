package javaconcurrent.threadpoolexecutor.awaitTermination;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * awaitTermination具有阻塞特性
 * 如果线程池没有shutdown，
 * 该方法就一直阻塞到time out 然后返回false，
 * 如果等到了，则返回true
 */
public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable2 myRunnable = new MyRunnable2();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 9999,
                9999, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        pool.execute(myRunnable);
        pool.execute(myRunnable);
        pool.execute(myRunnable);
        pool.execute(myRunnable);
        pool.shutdown();
        System.out.println("A= " + pool.awaitTermination(1, TimeUnit.SECONDS) + System.currentTimeMillis());
        System.out.println("B= " + pool.awaitTermination(1, TimeUnit.SECONDS) + System.currentTimeMillis());
        System.out.println("C= " + pool.awaitTermination(1, TimeUnit.SECONDS) + System.currentTimeMillis());
        System.out.println("D= " + pool.awaitTermination(1, TimeUnit.SECONDS) + System.currentTimeMillis());
        System.out.println("E= " + pool.awaitTermination(1, TimeUnit.SECONDS) + System.currentTimeMillis());

    }
}
