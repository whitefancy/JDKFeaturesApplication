package JDKFeaturesApplication.javaconcurrent.countdownlatch.await_timeout;

public class MyThread extends Thread {
    private MyService myService;

    public MyThread(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.testMethod();
    }
}
