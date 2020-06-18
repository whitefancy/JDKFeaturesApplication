package javaconcurrent.threadpoolexecutor.queuediffmaximum;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("begin " + System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end " + System.currentTimeMillis());
    }
}
