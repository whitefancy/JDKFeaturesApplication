package JDKFeaturesApplication.javaconcurrent.executor.newsinglethreadexecutor;

/**
 * 无界线程池
 */
public class MyRunnable implements Runnable {
    private String username;

    public MyRunnable(String username) {
        super();
        this.username = username;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() +
                    " username =" + username + " begin " + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() +
                    " username = " + username + " end " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
