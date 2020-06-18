package javaconcurrent.threadpoolexecutor.shutdown;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池使用了，程序先输出main end，然后一直运行
 */
public class Test2 {
    public static void main(String[] args) {
        MyRunnable1 myRunnable1 = new MyRunnable1();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(7, 10, 0L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        pool.execute(myRunnable1);
        System.out.println("main end!");
    }
}
