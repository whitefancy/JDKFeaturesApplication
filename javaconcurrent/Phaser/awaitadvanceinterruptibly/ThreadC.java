package javaconcurrent.Phaser.awaitadvanceinterruptibly;

import java.util.concurrent.Phaser;

public class ThreadC extends Thread {
    private Phaser phaser;

    public ThreadC(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " A1 begin= " + System.currentTimeMillis());
        try {
            phaser.awaitAdvanceInterruptibly(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "A1 end= " + System.currentTimeMillis());
    }
}
