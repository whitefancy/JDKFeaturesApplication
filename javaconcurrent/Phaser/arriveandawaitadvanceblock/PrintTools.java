package javaconcurrent.Phaser.arriveandawaitadvanceblock;

import java.util.concurrent.Phaser;

class PrintTools {
    static Phaser phaser;

    static void methodA() {
        System.out.println(Thread.currentThread().getName() + " A1 begin= " + System.currentTimeMillis());
        PrintTools.phaser.arriveAndAwaitAdvance();
        System.out.println(Thread.currentThread().getName() + "A1 end= " + System.currentTimeMillis());
        System.out.println(Thread.currentThread().getName() + " A2 begin= " + System.currentTimeMillis());
        PrintTools.phaser.arriveAndAwaitAdvance();
        System.out.println(Thread.currentThread().getName() + " A2 end= " + System.currentTimeMillis());

    }

    static void methodB() {
        System.out.println(Thread.currentThread().getName() + " A1 begin= " + System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PrintTools.phaser.arriveAndAwaitAdvance();
        System.out.println(Thread.currentThread().getName() + " A1 end= " + System.currentTimeMillis());

    }
}
