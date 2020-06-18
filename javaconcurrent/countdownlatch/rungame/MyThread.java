package javaconcurrent.countdownlatch.rungame;

import java.util.concurrent.CountDownLatch;

public class MyThread extends Thread {
    private CountDownLatch comingTag;//裁判等所有运动员到来
    private CountDownLatch waitTag;//裁判说预备
    private CountDownLatch waitRunTag;//等待起跑
    private CountDownLatch beginTag;//起跑
    private CountDownLatch endTag;//所有运动员到达终点

    MyThread(CountDownLatch comingTag, CountDownLatch waitTag, CountDownLatch waitRunTag, CountDownLatch beginTag, CountDownLatch endTag) {
        this.comingTag = comingTag;
        this.waitTag = waitTag;
        this.waitRunTag = waitRunTag;
        this.beginTag = beginTag;
        this.endTag = endTag;
    }

    @Override
    public void run() {
        try {
            System.out.println("运动员们从全国各地赶到起跑点，正在走");
            Thread.sleep((int) (Math.random() * 10000));
            System.out.println(Thread.currentThread().getName() + "到起跑点了");
            comingTag.countDown();
            System.out.println("等待裁判员说预备！");
            waitTag.await();
            System.out.println(Thread.currentThread().getName() + "正在做准备姿势");
            Thread.sleep((int) (Math.random() * 10000));
            waitRunTag.countDown();
            beginTag.await();
            System.out.println(Thread.currentThread().getName() + "开始跑了");
            Thread.sleep((int) (Math.random() * 10000));
            endTag.countDown();
            System.out.println(Thread.currentThread().getName() + "到终点了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
