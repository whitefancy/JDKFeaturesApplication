package javaconcurrent.Semaphore.semaphorefair.unfair;

import java.util.concurrent.Semaphore;

class MyService {
    private boolean isFair = false;
    private Semaphore semaphore = new Semaphore(1, isFair);

    void testMethod() {
        try {
            semaphore.acquire();
            System.out.println("Thread name = " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
