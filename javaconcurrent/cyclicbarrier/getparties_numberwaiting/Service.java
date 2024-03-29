package JDKFeaturesApplication.javaconcurrent.cyclicbarrier.getparties_numberwaiting;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Service {
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
        @Override
        public void run() {
            System.out.println("彻底结束了" + System.currentTimeMillis());
        }
    });

    public void testMethod() {
        try {
            System.out.println(Thread.currentThread().getName() + "准备 " + System.currentTimeMillis());
            if (Thread.currentThread().getName().equals("C")) {
                Thread.sleep(Integer.MAX_VALUE);
            }
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName() + "开始" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    CyclicBarrier getCyclicBarrier() {
        return cyclicBarrier;
    }
}
