package JDKFeaturesApplication.javaconcurrent.executor.newcachedthreadreuse;

public class MyRunnable implements Runnable {
    private String username;

    MyRunnable(String username) {
        super();
        this.username = username;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +
                "username =" + username + " begin " + System.currentTimeMillis());

        System.out.println(Thread.currentThread().getName() +
                "username =" + username + " end " + System.currentTimeMillis());

    }
}
