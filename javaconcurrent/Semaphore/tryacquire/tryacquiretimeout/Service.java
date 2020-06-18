package javaconcurrent.Semaphore.tryacquire.tryacquiretimeout;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class Service {
    private Semaphore semaphore = new Semaphore(1);

    /*
    构造参数permits 是许可的数目。代表同一时间内，最多允许多少个线程同时执行acquire（）和release()之间的代码
    无参数方法acquire()作用是使用一个许可，是减法操作。
     */
    void testMethod() {
        try {
            if (semaphore.tryAcquire(3, TimeUnit.SECONDS)) {
                System.out.println("Thread name = " + Thread.currentThread().getName() + " 首选进入！");
                for (int i = 0; i < Integer.MAX_VALUE / 50; i++) {
                    String newString = new String();
                    Math.random();
                }
                semaphore.release();
            } else {
                System.out.println("Thread name = " + Thread.currentThread().getName() + " 未成功进入！");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
