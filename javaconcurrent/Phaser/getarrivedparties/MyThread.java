package javaconcurrent.Phaser.getarrivedparties;

import java.util.concurrent.Phaser;

public class MyThread extends Thread {
    private Phaser phaser;

    public MyThread(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " A1 begin= " + System.currentTimeMillis());
        phaser.arriveAndAwaitAdvance();
        System.out.println(Thread.currentThread().getName() + "A1 end= " + System.currentTimeMillis());
    }
}
