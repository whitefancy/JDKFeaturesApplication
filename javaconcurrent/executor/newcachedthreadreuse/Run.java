package javaconcurrent.executor.newcachedthreadreuse;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService =
                Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyRunnable("" + (i + 1)));
        }
        Thread.sleep(1000);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyRunnable("" + (i + 5)));
        }
    }
}
