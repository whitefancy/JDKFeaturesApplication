package javaconcurrent.Phaser.getarrivedparties;

import java.util.concurrent.Phaser;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser(7);
        MyThread[] tArray = new MyThread[5];
        for (int i = 0; i < tArray.length; i++) {
            tArray[i] = new MyThread(phaser);
            tArray[i].setName("线程" + (i + 1));
            tArray[i].start();
        }
        Thread.sleep(2000);
        System.out.println("已到达：" + phaser.getArrivedParties());
        System.out.println("未到达：" + phaser.getUnarrivedParties());
    }
}
