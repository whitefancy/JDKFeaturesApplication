package javaconcurrent.countdownlatch.countDown10;

import java.util.concurrent.CountDownLatch;

public class MyThread extends Thread {
    private CountDownLatch maxRunner;

    MyThread(CountDownLatch maxRunner) {
        this.maxRunner = maxRunner;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "回来了");
            maxRunner.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
