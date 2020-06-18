package javaconcurrent.threadpoolexecutor.isterminating;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("我在运行" + System.currentTimeMillis() + " " + Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.println("我结束了" + System.currentTimeMillis() + " " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
