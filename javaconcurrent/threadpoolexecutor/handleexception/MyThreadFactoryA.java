package javaconcurrent.threadpoolexecutor.handleexception;

import java.util.Date;
import java.util.concurrent.ThreadFactory;

/**
 * 定制线程工厂
 */
public class MyThreadFactoryA implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("Ellie" + new Date());
        return thread;
    }
}
