package JDKFeaturesApplication.javaconcurrent.Phaser.arriveandawaitadvance;

import java.util.concurrent.Phaser;

public class ThreadB extends Thread {
    private Phaser phaser;

    ThreadB(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        PrintTools.methodA();
    }
}
