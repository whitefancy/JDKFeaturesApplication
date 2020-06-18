package javaconcurrent.Phaser.controlbegintime;

import java.util.concurrent.Phaser;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser(3);
        for (int i = 0; i < 3; i++) {
            ThreadA a = new ThreadA(phaser);
            a.start();
        }
    }
}
