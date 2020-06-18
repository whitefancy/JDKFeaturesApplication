package javaconcurrent.threadpoolexecutor.awaitTermination;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * awaitTermination结合shutdown可以实现等待执行完毕的效果。
 * 该方法就一直阻塞到time out 然后返回false，
 * 如果等到了，则返回true
 */
public class Test4 {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable2 myRunnable = new MyRunnable2();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 9999,
                9999, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        pool.execute(myRunnable);
        pool.execute(myRunnable);
        pool.execute(myRunnable);
        pool.execute(myRunnable);
        pool.shutdown();
        System.out.println("全部任务执行完毕！ " + pool.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS) + System.currentTimeMillis());

    }
}
