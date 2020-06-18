package javaconcurrent.executor.newfixedthreadpool;

import javaconcurrent.executor.newcachedthreadpool.MyRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run {
    public static void main(String[] args) {
        /*
        有界线程池
         */
        ExecutorService executorService =
                Executors.newFixedThreadPool(3);
        for (int i = 0; i < 6; i++) {
            executorService.execute(new MyRunnable("" + (i + 1)));
        }
    }
}
