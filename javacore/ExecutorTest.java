package javacore;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 执行器
 * 构建一个线程是有代价的，因为涉及与操作系统交互
 * 创建大量生命周期很短的线程，应该使用 线程池
 * 线程池中包含 许多准备运行的 空闲线程
 * 当run方法退出时，线程不会死亡，而是为下一个请求提供服务
 * <p>
 * 线程池可以减少并发线程的数目
 * 创建大量线程会降低性能甚至使虚拟机崩溃
 * 线程池的固定线程数目，可以限制并发的总数
 */
public class ExecutorTest {
    /*
     * 执行器类 Executor 有很多静态工厂方法 来构建线程池
     */
    private ExecutorService pool = null;

    {
        /*
        必要时创建新线程，空闲线程保留60秒
         */
        pool = Executors.newCachedThreadPool();
        /*
        固定数目，空闲线程一直保留
         */
        pool = Executors.newFixedThreadPool(10);
        /*
        只有一个线程，顺序执行每一个提交的任务
         */
        pool = Executors.newSingleThreadExecutor();
        /*
        预定执行而构建的固定线程池
         */
        pool = Executors.newScheduledThreadPool(10);
        /*
        预定执行构建的单线程池
         */
        pool = Executors.newSingleThreadScheduledExecutor();

        Runnable task1 = null;
        pool.submit(task1);
        Callable<Integer> task2 = null;
        Future<Integer> result = pool.submit(task2);
        /*
        想要取消某个任务，就要保存好返回的Future对象
         */
        Future<?> result1 = pool.submit(task1);
        result1.cancel(true);
        /*
        当用完一个线程池的时候，调用shutdown
        启动线程池的关闭序列
        被关闭的执行器，不再接受新的任务，
        所有的任务都完成后，线程死亡
        调用shutdownNow， 所有尚未开始的任务会被取消，并试图中断正在运行的线程
         */
    }
}
