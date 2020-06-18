package javaconcurrent.Phaser.onadvance;

import java.util.concurrent.Phaser;

class Service {
    private Phaser phaser;

    Service(Phaser phaser) {
        this.phaser = phaser;
    }

    public void testMethod() {
        try {
            System.out.println(Thread.currentThread().getName() + " A begin " + System.currentTimeMillis());
            if (Thread.currentThread().getName().equals("B")) {
                Thread.sleep(5000);
            }
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + " A end" + System.currentTimeMillis() + " end phase value =" + phaser.getPhase());
            System.out.println(Thread.currentThread().getName() + " B begin " + System.currentTimeMillis());
            if (Thread.currentThread().getName().equals("B")) {
                Thread.sleep(5000);
            }
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + " B end" + System.currentTimeMillis() + " end phase value =" + phaser.getPhase());
            System.out.println(Thread.currentThread().getName() + " C begin " + System.currentTimeMillis());
            if (Thread.currentThread().getName().equals("B")) {
                Thread.sleep(5000);
            }
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + " C end" + System.currentTimeMillis() + " end phase value =" + phaser.getPhase());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
