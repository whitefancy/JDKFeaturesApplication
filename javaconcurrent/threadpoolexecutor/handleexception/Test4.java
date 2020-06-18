package javaconcurrent.threadpoolexecutor.handleexception;


import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadFactory 自定义处理异常
 */
public class Test4 {
    public static void main(String[] args) {
        MyRunnable2 myRunnable1 = new MyRunnable2();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 9999, 9999,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        pool.setThreadFactory(new MyThreadFactoryB());
        pool.execute(myRunnable1);
    }
}
