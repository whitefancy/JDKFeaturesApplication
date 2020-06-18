package javaconcurrent.Phaser.awaitadvanceinterruptibly;

import java.util.concurrent.Phaser;

public class ThreadB extends Thread {
    private Phaser phaser;

    public ThreadB(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " A1 begin= " + System.currentTimeMillis());
        try {
            phaser.awaitAdvanceInterruptibly(0);
            System.out.println(Thread.currentThread().getName() + "A1 end= " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
