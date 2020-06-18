package javaconcurrent.cyclicbarrier.numberwaiting;

import java.util.concurrent.CyclicBarrier;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cbRef = new CyclicBarrier(3);
        MyThread[] tArray = new MyThread[6];
        for (int i = 0; i < tArray.length; i++) {
            tArray[i] = new MyThread(cbRef);
        }
        for (int i = 0; i < tArray.length; i++) {
            tArray[i].start();
            Thread.sleep(500);
            System.out.println(cbRef.getNumberWaiting());//1 2 0 1 2 0
        }
    }
}
