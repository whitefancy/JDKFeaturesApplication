package javaconcurrent.Phaser.arriveandderegister;

import java.util.concurrent.Phaser;

public class ThreadC extends Thread {
    private Phaser phaser;

    public ThreadC(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        PrintTools.methodB();
    }
}
