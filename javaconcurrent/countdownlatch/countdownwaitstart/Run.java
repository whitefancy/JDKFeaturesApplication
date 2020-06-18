package javaconcurrent.countdownlatch.countdownwaitstart;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        MyThread[] tArray = new MyThread[10];
        for (int i = 0; i < tArray.length; i++) {
            tArray[i] = new MyThread(myService);
            tArray[i].setName("线程" + (i + 1));
            tArray[i].start();
        }
        Thread.sleep(2000);
        myService.downMethod();
    }
}
