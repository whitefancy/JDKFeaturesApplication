package javaconcurrent.cyclicbarrier.await_timeout;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Service {
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
        @Override
        public void run() {
            System.out.println("彻底结束了" + System.currentTimeMillis());
        }
    });

    public void testMethod() {
        try {
            System.out.println(Thread.currentThread().getName() + "准备 " + System.currentTimeMillis());
            if (Thread.currentThread().getName().equals("Thread-0")) {
                System.out.println("Thread-0执行了" +
                        "cyclicBarrier.await(5, TimeUnit.SECONDS)");
                cyclicBarrier.await(5, TimeUnit.SECONDS);
            }
            if (Thread.currentThread().getName().equals("Thread-1")) {
                System.out.println("Thread-1执行了" +
                        "cyclicBarrier.await()");
                cyclicBarrier.await();
            }
            System.out.println(Thread.currentThread().getName() + "开始" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
