package javaconcurrent.Semaphore.addpermitsCount;


import java.util.concurrent.Semaphore;

public class Run {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        try {
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            System.out.println(semaphore.availablePermits());//0
            semaphore.release();
            semaphore.release();
            System.out.println(semaphore.availablePermits());//2
            semaphore.release(10);
            System.out.println(semaphore.availablePermits());//12
            /*
            多次调用release，或release（int）,可以动态增加permits的个数，
            构造参数中的permits数量是初始值，不是最终的许可数量。
             */
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
