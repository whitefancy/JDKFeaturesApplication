package JDKFeaturesApplication.javaconcurrent.threadpoolexecutor.awaitTermination;

public class MyRunnable2 implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
