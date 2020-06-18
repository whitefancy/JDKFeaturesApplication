package javaconcurrent.threadpoolexecutor.coreThreadTimeout;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis());
        System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis());
    }
}
