package javaconcurrent.Semaphore.aquireUniterruptibly;

import java.util.concurrent.Semaphore;

class Service {
    private Semaphore semaphore = new Semaphore(1);

    /*
    构造参数permits 是许可的数目。代表同一时间内，最多允许多少个线程同时执行acquire（）和release()之间的代码
    无参数方法acquire()作用是使用一个许可，是减法操作。
     */
    void testMethod() {
        semaphore.acquireUninterruptibly();
        System.out.println(Thread.currentThread().getName() + " begin timer=" + System.currentTimeMillis());
        for (int i = 0; i < Integer.MAX_VALUE / 50; i++) {
            String newString = new String();
            Math.random();
        }
        System.out.println(Thread.currentThread().getName() + " end timer=" + System.currentTimeMillis());
        semaphore.release();
    }
}
