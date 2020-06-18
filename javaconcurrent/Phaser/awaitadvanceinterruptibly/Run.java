package javaconcurrent.Phaser.awaitadvanceinterruptibly;

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
        b.start();
        a.start();
        c.start();
        try {
            Thread.sleep(5000);
            a.interrupt();
            b.interrupt();
            System.out.println("中断了a,b");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
