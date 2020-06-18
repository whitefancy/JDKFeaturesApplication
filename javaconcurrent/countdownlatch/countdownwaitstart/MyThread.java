package javaconcurrent.countdownlatch.countdownwaitstart;

public class MyThread extends Thread {
    private MyService myService;

    MyThread(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.testMethod();
    }
}
