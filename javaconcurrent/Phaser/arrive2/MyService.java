package javaconcurrent.Phaser.arrive2;

import java.util.concurrent.Phaser;

class MyService {
    private Phaser phaser;

    MyService(Phaser phaser) {
        this.phaser = phaser;
    }

    void methodA() {
        try {
            System.out.println(Thread.currentThread().getName() +
                    " A1 begin= " + System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println(phaser.getArrivedParties());
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() +
                    " A1 end= " + System.currentTimeMillis());
            System.out.println(Thread.currentThread().getName() +
                    " A2 begin= " + System.currentTimeMillis());
            Thread.sleep(3000);
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() +
                    " A2 end= " + System.currentTimeMillis());
            System.out.println(Thread.currentThread().getName() +
                    " A3 begin= " + System.currentTimeMillis());
            Thread.sleep(3000);
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() +
                    " A3 end= " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void methodB() {
        System.out.println(Thread.currentThread().getName() +
                " A1 begin= " + System.currentTimeMillis());
        phaser.arrive();
        System.out.println(Thread.currentThread().getName() +
                "A1 end= " + System.currentTimeMillis());
        System.out.println(Thread.currentThread().getName() +
                " A2 begin= " + System.currentTimeMillis());
        phaser.arrive();
        System.out.println(Thread.currentThread().getName() +
                " A2 end= " + System.currentTimeMillis());
        System.out.println(Thread.currentThread().getName() +
                " A3 begin= " + System.currentTimeMillis());
        phaser.arrive();
        System.out.println(Thread.currentThread().getName() +
                " A3 end= " + System.currentTimeMillis());
    }
}
