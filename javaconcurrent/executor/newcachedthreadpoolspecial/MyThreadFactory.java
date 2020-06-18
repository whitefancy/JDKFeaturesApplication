package javaconcurrent.executor.newcachedthreadpoolspecial;

import java.util.concurrent.ThreadFactory;

/**
 * 定制线程工厂
 */
public class MyThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("定制池中线程对象的名称" + Math.random());
        return thread;
    }
}
