package javaconcurrent.threadpoolexecutor.handleexception;

public class MyRunnable2 implements Runnable {
    @Override
    public void run() {
        System.out.println("我在运行" + System.currentTimeMillis() + " " + Thread.currentThread().getName());

        String abc = null;
        abc.indexOf(0);
        System.out.println("我结束了" + System.currentTimeMillis() + " " + Thread.currentThread().getName());

    }
}
