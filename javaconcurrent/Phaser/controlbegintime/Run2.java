package javaconcurrent.Phaser.controlbegintime;

import java.util.concurrent.Phaser;

public class Run2 {
    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser(3);
        phaser.register();
        for (int i = 0; i < 3; i++) {
            ThreadA a = new ThreadA(phaser);
            a.start();
        }
        Thread.sleep(5000);
        phaser.arriveAndDeregister();
    }
}
