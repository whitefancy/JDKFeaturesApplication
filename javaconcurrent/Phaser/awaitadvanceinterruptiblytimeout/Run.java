package javaconcurrent.Phaser.awaitadvanceinterruptiblytimeout;

import java.util.concurrent.Phaser;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser(3);
        ThreadA a = new ThreadA(phaser);
        a.setName("A");
        a.start();
        Thread.sleep(1000);
        phaser.arrive();
        Thread.sleep(1000);
        phaser.arrive();
        Thread.sleep(1000);
        phaser.arrive();
        System.out.println(System.currentTimeMillis());
    }
}
