package javaconcurrent.Semaphore.drainPermits.availablePermits;

import java.util.concurrent.Semaphore;

class MyService {
    private Semaphore semaphore = new Semaphore(10);

    void testMethod() {
        try {
            semaphore.acquire();
            System.out.println(semaphore.availablePermits());
            System.out.println(semaphore.availablePermits());
            System.out.println(semaphore.availablePermits());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
