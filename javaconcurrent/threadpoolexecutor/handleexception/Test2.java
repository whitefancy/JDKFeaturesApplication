package javaconcurrent.threadpoolexecutor.handleexception;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadFactory 对线程池中线程做定制化 execute
 */
public class Test2 {
    public static void main(String[] args) {
        MyRunnable1 myRunnable1 = new MyRunnable1();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 9999, 9999,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        pool.setThreadFactory(new MyThreadFactoryA());
        pool.execute(myRunnable1);
    }
}
