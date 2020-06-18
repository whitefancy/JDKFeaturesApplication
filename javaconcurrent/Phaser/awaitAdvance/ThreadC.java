package javaconcurrent.Phaser.awaitAdvance;

import java.util.concurrent.Phaser;

public class ThreadC extends Thread {
    private Phaser phaser;

    public ThreadC(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " A1 begin= " + System.currentTimeMillis());
            Thread.sleep(3000);
            phaser.awaitAdvance(0);
            System.out.println(Thread.currentThread().getName() + "A1 end= " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
