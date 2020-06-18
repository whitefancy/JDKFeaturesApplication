package javaconcurrent.threadpoolexecutor.shutdown;

public class MyRunnable1 implements Runnable {
    @Override
    public void run() {
        System.out.println("我在运行" + System.currentTimeMillis() + " " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我结束了" + System.currentTimeMillis() + " " + Thread.currentThread().getName());

    }
}
