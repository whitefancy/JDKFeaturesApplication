package javaconcurrent.Phaser.bulkRegister;


import java.util.concurrent.Phaser;

public class Run {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(5);
        System.out.println(phaser.getRegisteredParties());
        phaser.bulkRegister(10);
        System.out.println(phaser.getRegisteredParties());
        phaser.bulkRegister(5);
        System.out.println(phaser.getRegisteredParties());
        phaser.bulkRegister(2);
        System.out.println(phaser.getRegisteredParties());
        phaser.bulkRegister(1);
        System.out.println(phaser.getRegisteredParties());
    }
}
