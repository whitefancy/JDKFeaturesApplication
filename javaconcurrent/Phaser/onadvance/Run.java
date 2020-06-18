package javaconcurrent.Phaser.onadvance;

import java.util.concurrent.Phaser;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser(2) {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println("protected boolean onAdvance(int phase, int registeredParties) 被调用！");
                if (phase == 0) {
                    return false;
                } else {
                    return true;
                }
                //返回true则不等待了，Phaser呈无效/销毁的状态
                //返回false则Phaser继续工作
            }
        };
        Service service = new Service(phaser);
        TheadA a = new TheadA(service);
        a.setName("A");
        TheadB b = new TheadB(service);
        b.setName("B");
        a.start();
        b.start();
    }
}
