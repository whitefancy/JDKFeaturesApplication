package javaconcurrent.executor.newfixedthreadpoolfactory;

import javaconcurrent.executor.newcachedthreadpoolspecial.MyThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run {
    public static void main(String[] args) {
        MyThreadFactory threadFactory = new MyThreadFactory();
        ExecutorService executorService =
                Executors.newFixedThreadPool(2, threadFactory);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("我在运行" + System.currentTimeMillis() + " " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我结束了" + System.currentTimeMillis() + " " + Thread.currentThread().getName());

            }
        };
        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.execute(runnable);
    }
}
