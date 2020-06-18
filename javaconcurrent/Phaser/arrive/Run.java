package javaconcurrent.Phaser.arrive;


import java.util.concurrent.Phaser;

public class Run {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(2) {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println("到达了,即将通过！phase=第" + phase + "轮 registeredParties=" + registeredParties);
                return super.onAdvance(phase, registeredParties);
                //返回true则不等待了，Phaser呈无效/销毁的状态
                //返回false则Phaser继续工作
            }
        };
        System.out.println("A1 phase=第" + phaser.getPhase() + "轮 registeredParties=" + phaser.getRegisteredParties());
        phaser.arrive();
        System.out.println("A1 phase=第" + phaser.getPhase() + "轮 registeredParties=" + phaser.getRegisteredParties());
        System.out.println("A2 phase=第" + phaser.getPhase() + "轮 registeredParties=" + phaser.getRegisteredParties());
        phaser.arrive();
        System.out.println("A2 phase=第" + phaser.getPhase() + "轮 registeredParties=" + phaser.getRegisteredParties());
        System.out.println("B1 phase=第" + phaser.getPhase() + "轮 registeredParties=" + phaser.getRegisteredParties());
        phaser.arrive();
        System.out.println("B1 phase=第" + phaser.getPhase() + "轮 registeredParties=" + phaser.getRegisteredParties());
        System.out.println("B2 phase=第" + phaser.getPhase() + "轮 registeredParties=" + phaser.getRegisteredParties());
        phaser.arrive();
        System.out.println("B2 phase=第" + phaser.getPhase() + "轮 registeredParties=" + phaser.getRegisteredParties());
        System.out.println("C1 phase=第" + phaser.getPhase() + "轮 registeredParties=" + phaser.getRegisteredParties());
        phaser.arrive();
        System.out.println("C1 phase=第" + phaser.getPhase() + "轮 registeredParties=" + phaser.getRegisteredParties());
        System.out.println("C2 phase=第" + phaser.getPhase() + "轮 registeredParties=" + phaser.getRegisteredParties());
        phaser.arrive();
        System.out.println("C2 phase=第" + phaser.getPhase() + "轮 registeredParties=" + phaser.getRegisteredParties());
    }
}
