package JDKFeaturesApplication.javaconcurrent.countdownlatch.rungame;

import java.util.concurrent.CountDownLatch;

public class MyService {
    private CountDownLatch down = new CountDownLatch(1);

    public void testMethod() {
        try {
            System.out.println(Thread.currentThread().getName() + "准备");
            down.await();
            System.out.println(Thread.currentThread().getName() + "结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void downMethod() {
        System.out.println("开始");
        down.countDown();
    }
}
