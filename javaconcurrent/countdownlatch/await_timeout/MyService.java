package javaconcurrent.countdownlatch.await_timeout;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class MyService {
    private CountDownLatch down = new CountDownLatch(1);

    public void testMethod() {
        try {
            System.out.println(Thread.currentThread().getName() + " 准备 " + System.currentTimeMillis());

            down.await(3, TimeUnit.SECONDS);
            System.out.println(Thread.currentThread().getName() + " 结束 " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void downMethod() {
        System.out.println("X");
        down.countDown();
    }
}
