package javaconcurrent.threadpoolexecutor.rejectPolicy;

public class MyThreadB extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " run end!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
