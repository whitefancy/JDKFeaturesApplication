package javaconcurrent.Phaser.awaitAdvance;


import java.util.concurrent.Phaser;

public class Run {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);
        ThreadA a = new ThreadA(phaser);
        a.setName("A");
        ThreadB b = new ThreadB(phaser);
        b.setName("B");
        ThreadC c = new ThreadC(phaser);
        c.setName("C");
        ThreadD d = new ThreadD(phaser);
        d.setName("D");
        d.start();
        a.start();
        c.start();
        b.start();
    }
}
