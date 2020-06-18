package javaconcurrent.threadpoolexecutor.rejectPolicy;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadA extends Thread {
    @Override
    public void run() {
        Runnable runnable = new MyThreadA();
        LinkedBlockingDeque queue = new LinkedBlockingDeque(2);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2,
                5, TimeUnit.SECONDS, queue,
                new ThreadPoolExecutor.CallerRunsPolicy());
        System.out.println("A begin " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        System.out.println("A end " + Thread.currentThread().getName() + " " + System.currentTimeMillis());

    }
}
