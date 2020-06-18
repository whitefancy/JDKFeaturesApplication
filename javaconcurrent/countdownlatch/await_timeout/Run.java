package javaconcurrent.countdownlatch.await_timeout;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        MyThread[] tArray = new MyThread[3];
        for (int i = 0; i < tArray.length; i++) {
            tArray[i] = new MyThread(myService);
        }
        for (int i = 0; i < tArray.length; i++) {
            tArray[i].start();
        }
    }
}
