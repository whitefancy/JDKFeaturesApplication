package javaconcurrent.Semaphore.permitsdynamic;

import java.util.concurrent.Semaphore;

class Service {
    private Semaphore semaphore = new Semaphore(10);

    /*
    构造参数permits 是许可的数目。代表同一时间内，最多允许多少个线程同时执行acquire（）和release()之间的代码
    无参数方法acquire()作用是使用一个许可，是减法操作。
     */
    void testMethod() {
        try {
            semaphore.acquire(2);
            /*
            10/2=5,共有10个许可，所以最多有5个线程允许执行之间的代码
             */
            System.out.println(Thread.currentThread().getName() + " begin timer=" + System.currentTimeMillis());
            int sleepValue = ((int) (Math.random() * 10000));
            System.out.println(Thread.currentThread().getName() + " 停止了 " + sleepValue / 1000 + " 秒");
            Thread.sleep(sleepValue);
            System.out.println(Thread.currentThread().getName() + " end timer=" + System.currentTimeMillis());
            semaphore.release(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
