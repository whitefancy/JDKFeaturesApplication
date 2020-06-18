package javaconcurrent.Phaser.arrive2;

public class ThreadC extends Thread {
    private MyService myService;

    public ThreadC(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.methodB();
    }
}
