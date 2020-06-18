package javaconcurrent.Phaser.awaitadvanceinterruptiblytimeout;

import java.util.concurrent.Phaser;

public class Run3 {
    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser(3);
        ThreadA a = new ThreadA(phaser);
        a.setName("A");
        a.start();
        Thread.sleep(1000);
        a.interrupt();
    }
}
