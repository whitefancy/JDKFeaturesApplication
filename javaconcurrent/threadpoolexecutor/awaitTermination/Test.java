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
public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable1 myRunnable = new MyRunnable1();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 9999,
                9999, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        pool.execute(myRunnable);
        System.out.println("main begin! " + System.currentTimeMillis());
        System.out.println(pool.awaitTermination(10, TimeUnit.SECONDS));
        System.out.println("main end! " + System.currentTimeMillis());
    }
}
