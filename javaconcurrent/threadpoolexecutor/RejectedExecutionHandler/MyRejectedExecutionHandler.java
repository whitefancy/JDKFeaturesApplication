package javaconcurrent.threadpoolexecutor.RejectedExecutionHandler;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程被拒绝的处理
 * 线程池内线程不够时，同步queue中的线程会被拒绝执行
 * 如果不handle这个错误，会抛出异常
 */
public class MyRejectedExecutionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(((MyRunnable1) r).getUsername() + " 被拒绝执行");
    }
}
