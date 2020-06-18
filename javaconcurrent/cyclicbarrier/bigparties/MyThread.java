package javaconcurrent.cyclicbarrier.bigparties;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyThread extends Thread {
    private CyclicBarrier cbRef;

    MyThread(CyclicBarrier cbRef) {
        this.cbRef = cbRef;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 1000));
            System.out.println(Thread.currentThread().getName() + "等待凑齐两个继续运行" + System.currentTimeMillis());
            cbRef.await();
            System.out.println(Thread.currentThread().getName() + "凑齐两个了，运行" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
