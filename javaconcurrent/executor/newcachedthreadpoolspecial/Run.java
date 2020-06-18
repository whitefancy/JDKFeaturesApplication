package javaconcurrent.executor.newcachedthreadpoolspecial;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run {
    public static void main(String[] args) {
        MyThreadFactory threadFactory = new MyThreadFactory();
        ExecutorService executorService =
                Executors.newCachedThreadPool(threadFactory);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("我在运行" + System.currentTimeMillis() + " " + Thread.currentThread().getName());
            }
        });
    }
}
