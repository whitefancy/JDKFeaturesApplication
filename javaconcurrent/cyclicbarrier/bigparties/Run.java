package javaconcurrent.cyclicbarrier.bigparties;

import java.util.concurrent.CyclicBarrier;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cbRef = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("全来了");
            }
        });
        MyThread[] tArray = new MyThread[4];
        for (int i = 0; i < tArray.length; i++) {
            tArray[i] = new MyThread(cbRef);
        }
        for (int i = 0; i < tArray.length; i++) {
            tArray[i].start();
            Thread.sleep(2000);
        }
    }
}
