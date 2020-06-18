package javaconcurrent.Phaser.forceTermination;

import java.util.concurrent.Phaser;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser(3);
        ThreadA a = new ThreadA(phaser);
        a.setName("A");
        ThreadB b = new ThreadB(phaser);
        b.setName("B");
        b.start();
        a.start();
        Thread.sleep(1000);
        phaser.forceTermination();
        System.out.println(phaser.isTerminated());
    }
}
