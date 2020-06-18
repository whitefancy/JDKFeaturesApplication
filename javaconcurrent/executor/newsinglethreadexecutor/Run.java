package javaconcurrent.executor.newsinglethreadexecutor;

import javaconcurrent.executor.newcachedthreadpool.MyRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run {
    public static void main(String[] args) {
        ExecutorService executorService =
                Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyRunnable("" + (i + 1)));
        }
    }
}
