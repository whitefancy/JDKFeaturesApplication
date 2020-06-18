package javaconcurrent.Semaphore.queuedthread;

import java.util.concurrent.Semaphore;

class MyService {
    private Semaphore semaphore = new Semaphore(1);

    void testMethod() {
        try {
            semaphore.acquire();
            Thread.sleep(1000);
            System.out.println("还有大约" + semaphore.getQueueLength() + " 个线程在等待");
            System.out.println("是否有线程在等待？ " + semaphore.hasQueuedThreads());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
