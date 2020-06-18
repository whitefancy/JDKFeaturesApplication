package javaconcurrent.countdownlatch.countDown1;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        MyThread t = new MyThread(myService);
        t.start();
        Thread.sleep(2000);
        myService.downMethod();
    }
}
