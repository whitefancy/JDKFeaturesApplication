package javaconcurrent.Phaser.arriveandderegister;

import java.util.concurrent.Phaser;

public class Run {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);
        PrintTools.phaser = phaser;
        ThreadA a = new ThreadA(phaser);
        a.setName("A");
        ThreadB b = new ThreadB(phaser);
        b.setName("B");
        ThreadC c = new ThreadC(phaser);
        c.setName("C");
        a.start();
        c.start();
        b.start();
    }
}
