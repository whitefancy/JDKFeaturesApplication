package javaconcurrent.cyclicbarrier.isbroken;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyService {
    private CyclicBarrier cbRef;

    MyService(CyclicBarrier cbRef) {
        this.cbRef = cbRef;
    }

    private void beginRun(int count) {
        try {
            System.out.println(Thread.currentThread().getName() + "到了，等待其他人都到了开始起跑 " + System.currentTimeMillis());
            if (Thread.currentThread().getName().equals("Thread-2")) {
                System.out.println("Thread-2进来了");
                Thread.sleep(1000);
                Integer.parseInt("a");
            }
            if (Thread.currentThread().getName().equals("Thread-3")) {
                System.out.println("Thread-3进来了");
                Thread.currentThread().interrupt();
            }
            cbRef.await();
            System.out.println("都到了，开始跑！");
            System.out.println(Thread.currentThread().getName() + System.currentTimeMillis() + "到达终点，并结束第 " + count + "赛段");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    void testA() {
        //比赛1个赛段
        for (int i = 0; i < 1; i++) {
            beginRun(i + 1);
        }
    }
}
