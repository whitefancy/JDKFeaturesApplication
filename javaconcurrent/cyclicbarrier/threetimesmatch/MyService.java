package javaconcurrent.cyclicbarrier.threetimesmatch;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyService {
    private CyclicBarrier cbRef;

    MyService(CyclicBarrier cbRef) {
        this.cbRef = cbRef;
    }

    void beginRun() {
        try {
            long sleepValue = (int) (Math.random() * 10000);
            Thread.sleep(sleepValue);
            System.out.println(Thread.currentThread().getName() + System.currentTimeMillis() + "开始跑第一阶段 " + (cbRef.getNumberWaiting() + 1));
            cbRef.await();
            System.out.println(Thread.currentThread().getName() + System.currentTimeMillis() + "结束第一阶段 " + (cbRef.getNumberWaiting() + 1));
            Thread.sleep(sleepValue);
            System.out.println(Thread.currentThread().getName() + System.currentTimeMillis() + "开始跑第二阶段 " + (cbRef.getNumberWaiting() + 1));
            cbRef.await();
            System.out.println(Thread.currentThread().getName() + System.currentTimeMillis() + "结束第二阶段 " + (cbRef.getNumberWaiting() + 1));
            Thread.sleep(sleepValue);
            System.out.println(Thread.currentThread().getName() + System.currentTimeMillis() + "开始跑第三阶段 " + (cbRef.getNumberWaiting() + 1));
            cbRef.await();
            System.out.println(Thread.currentThread().getName() + System.currentTimeMillis() + "结束第三阶段 " + (cbRef.getNumberWaiting() + 1));

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
