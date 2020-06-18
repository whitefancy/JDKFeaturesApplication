package javaconcurrent.Phaser.awaitadvanceinterruptiblytimeout;

import java.util.concurrent.Phaser;

public class Run2 {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);
        ThreadA a = new ThreadA(phaser);
        a.setName("A");
        a.start();

    }
}
