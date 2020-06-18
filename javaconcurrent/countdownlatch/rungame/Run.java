package javaconcurrent.countdownlatch.rungame;

import java.util.concurrent.CountDownLatch;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        int count = 4;//运动员数目
        CountDownLatch comingTag = new CountDownLatch(count);//裁判等所有运动员到来
        CountDownLatch waitTag = new CountDownLatch(1);//裁判说预备
        CountDownLatch waitRunTag = new CountDownLatch(count);//等待起跑
        CountDownLatch beginTag = new CountDownLatch(1);//起跑
        CountDownLatch endTag = new CountDownLatch(count);//所有运动员到达终点
        MyThread[] tArray = new MyThread[count];
        for (int i = 0; i < tArray.length; i++) {
            tArray[i] = new MyThread(comingTag, waitTag, waitRunTag, beginTag, endTag);
            tArray[i].setName("线程" + (i + 1));
            tArray[i].start();
        }
        System.out.println("裁判在等待选手们到来");
        comingTag.await();
        System.out.println("所有选手都来了，裁判员巡视5秒");
        Thread.sleep(5000);
        waitTag.countDown();
        System.out.println("各就各位！");
        waitRunTag.await();
        Thread.sleep(2000);
        System.out.println("发令枪响起");
        beginTag.countDown();
        endTag.await();
        System.out.println("所有运动员到达，统计名次");
    }
}
